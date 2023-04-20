package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {

    private final TcpConnection tcpConnection;

    public Connected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getState() {
        return "connected";
    }

    @Override
    public void connect() {
        System.out.println("Error");
    }

    @Override
    public void disconnect() {
        tcpConnection.setCurrentState(new Disconnected(tcpConnection));
    }

    @Override
    public void write(String data) {
        System.out.println(data + " written to buffer");
    }
}
// END
