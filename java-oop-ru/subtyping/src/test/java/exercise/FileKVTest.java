package exercise;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileKVTest {

    private static final Path FILEPATH = Paths.get("src/test/resources/file").toAbsolutePath()
                                              .normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(FILEPATH, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    void test() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));

        // Проверка чтения существующего и несуществующего элемента
        assertThat(storage.get("key", "default")).isEqualTo("value");
        assertThat(storage.get("key2", "default")).isEqualTo("default");

        // Проверка удаления элемента
        storage.unset("key");
        assertThat(storage.get("key", "default")).isEqualTo("default");

        // Проверка добавления элемента
        storage.set("key3", "value3");
        assertThat(storage.get("key3", "default")).isEqualTo("value3");

        // Проверка toMap()
        assertThat(storage.toMap()).isEqualTo(Map.of("key3", "value3"));
    }
    // END
}
