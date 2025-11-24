package com.hilllel.cw_41;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TcpServer {
    private static final Logger logger = Logger.getLogger(TcpServer.class.getName());

    private final int port;
    private final AtomicInteger clientCounter = new AtomicInteger(0);
    private final Map<String, ConnectionInfo> activeConnections = new ConcurrentHashMap<>();
    private final ExecutorService handlers = Executors.newCachedThreadPool();
    private volatile boolean running = true;
    private ServerSocket serverSocket;

    public TcpServer(int port) {
        this.port = port;
    }


    public void start() throws IOException {
        serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(port));
        logger.info(() -> String.format("[SERVER] Listening on %d", port));

        while (running) {
            try {
                Socket socket = serverSocket.accept();
                String name = "client-" + clientCounter.incrementAndGet();
                ConnectionInfo ci = new ConnectionInfo(name, socket);
                activeConnections.put(name, ci);
                logger.info(() -> String.format("[SERVER] %s successfully connected from %s at %s", name, socket.getRemoteSocketAddress(), Instant.now()));
                handlers.execute(new ClientHandler(this, ci));
            } catch (IOException e) {
                if (running) logger.log(Level.SEVERE, "Error accepting connection", e);
            }
        }

        shutdown();
    }

    public Map<String, ConnectionInfo> getActiveConnections() {
        return activeConnections;
    }

    public void removeConnection(String name) {
        ConnectionInfo ci = activeConnections.remove(name);
        if (ci != null) {
            logger.info(() -> String.format("[SERVER] Removing connection %s", name));
            ci.close();
        }
    }

    public void shutdown() {
        running = false;
        try {
            if (serverSocket != null && !serverSocket.isClosed()) serverSocket.close();
        } catch (IOException ignored) {}
        handlers.shutdownNow();
        activeConnections.values().forEach(ConnectionInfo::close);
        logger.info("[SERVER] Shutdown complete");
    }

    public static void main(String[] args) throws IOException {
        int port = 12345;
        if (args.length > 0) {
            try { port = Integer.parseInt(args[0]); } catch (NumberFormatException ignored) {}
        }
        TcpServer server = new TcpServer(port);
        server.start();
    }
}

