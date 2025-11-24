Simple TCP server and client for cw_41

Files:
- ConnectionInfo.java - metadata for active connections
- ClientHandler.java - per-client reader and command processor
- TcpServer.java - main server that accepts connections and tracks active ones
- TcpClient.java - simple console client to connect and send commands

How to run:
1. From IDE: Run com.hilllel.cw_41.TcpServer (or use command line)
   - Default port: 12345. You can pass a port as program arg.
2. Start one or more clients: run com.hilllel.cw_41.TcpClient
   - You can pass host and port as args: e.g. localhost 12345
3. In client console type any text to send; type `exit` to disconnect from server.

Behavior:
- Server assigns names client-1, client-2, ... and logs connections to cw/logs/info/info.log
- Server supports special command `exit` which disconnects the sending client and removes it from active connections.
- Server echoes non-command lines back to the sender with prefix [ECHO]

Notes:
- Logs directory should exist (cw/logs/info). If not, server will log to console only.
- This is a simple demo; for production consider robust logging, config, and graceful shutdown handling.

