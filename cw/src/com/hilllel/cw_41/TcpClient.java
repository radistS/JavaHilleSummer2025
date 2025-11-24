package com.hilllel.cw_41;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;
        if (args.length > 0) host = args[0];
        if (args.length > 1) {
            try { port = Integer.parseInt(args[1]); } catch (NumberFormatException ignored) {}
        }

        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port));
            System.out.println("Connected to server " + socket.getRemoteSocketAddress());

            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));

            Thread readerThread = new Thread(() -> {
                try {
                    String line;
                    while ((line = serverReader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    // connection closed
                }
            }, "server-reader");
            readerThread.setDaemon(true);
            readerThread.start();

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
            String input;
            while ((input = console.readLine()) != null) {
                input = input.trim();
                if (input.isEmpty()) continue;
                writer.write(input);
                writer.write("\n");
                writer.flush();
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("Failed to connect or communicate with server: " + e.getMessage());
        }

        System.out.println("Client terminated");
    }
}

