package exercise;

import exercise.connections.Connection;
import exercise.connections.Disconnected;

// BEGIN
public class TcpConnection {

    private String ip;
    private int port;

    private Connection connection;

    public TcpConnection(
            String ip,
            int port) {
        this.ip = ip;
        this.port = port;
        this.connection = new Disconnected(this);
    }

    public String getCurrentState() {
        return connection.getState();
    }

    public void setCurrentState(Connection con) {
        this.connection = con;
    }

    public void connect() {
        connection.connect();
    }

    public void disconnect() {
        connection.disconnect();
    }

    public void write(String data) {
        connection.write(data);
    }
}
// END
