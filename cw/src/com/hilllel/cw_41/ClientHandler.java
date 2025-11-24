package com.hilllel.cw_41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientHandler implements Runnable {
    private static final Logger logger = Logger.getLogger(ClientHandler.class.getName());

    private final TcpServer server;
    private final ConnectionInfo connection;

    public ClientHandler(TcpServer server, ConnectionInfo connection) {
        this.server = server;
        this.connection = connection;
    }

    @Override
    public void run() {
        Socket socket = connection.getSocket();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8))) {
            // send welcome
            connection.sendMessage("[SERVER] Welcome " + connection.getName());

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                logger.log(Level.INFO, String.format("[SERVER] Received from %s: %s", connection.getName(), line));

                if ("exit".equalsIgnoreCase(line)) {
                    connection.sendMessage("[SERVER] Bye " + connection.getName());
                    logger.log(Level.INFO, String.format("[SERVER] %s requested exit", connection.getName()));
                    if (server != null) server.removeConnection(connection.getName());
                    break;
                } else {
                    // For now just echo back
                    connection.sendMessage("[ECHO] " + line);
                }
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "IO error in handler for " + connection.getName(), e);
        } finally {
            if (server != null) server.removeConnection(connection.getName());
            try {
                if (!socket.isClosed()) socket.close();
            } catch (IOException ignored) {}
            logger.log(Level.INFO, String.format("[SERVER] Handler ended for %s", connection.getName()));
        }
    }
}
