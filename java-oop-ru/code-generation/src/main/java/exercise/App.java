package exercise;

import java.nio.file.Files;
import java.nio.file.Path;
import lombok.SneakyThrows;

// BEGIN
public class App {

    @SneakyThrows
    public static void save(
            Path path,
            Car car) {
        Files.write(path, car.serialize().getBytes());
    }

    @SneakyThrows
    public static Car extract(Path path) {
        try (var lines = Files.lines(path)) {
            return Car.unserialize(lines.reduce("", String::concat));
        }
    }
}
// END
