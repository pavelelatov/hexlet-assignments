package exercise.connections;

public interface Connection {

    // BEGIN
    String getState();

    void connect();

    void disconnect();

    void write(String data);
    // END
}
