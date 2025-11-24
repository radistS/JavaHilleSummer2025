package com.hilllel.cw_41;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.Instant;

public class ConnectionInfo {
    private final String name;
    private final Socket socket;
    private final Instant connectedAt;
    private final BufferedWriter writer;

    public ConnectionInfo(String name, Socket socket) throws IOException {
        this.name = name;
        this.socket = socket;
        this.connectedAt = Instant.now();
        this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
    }

    public String getName() {
        return name;
    }

    public Socket getSocket() {
        return socket;
    }

    public Instant getConnectedAt() {
        return connectedAt;
    }

    public synchronized void sendMessage(String msg) throws IOException {
        writer.write(msg);
        writer.write("\n");
        writer.flush();
    }

    public synchronized void close() {
        try {
            writer.flush();
        } catch (IOException ignored) {}
        try {
            socket.close();
        } catch (IOException ignored) {}
    }
}

