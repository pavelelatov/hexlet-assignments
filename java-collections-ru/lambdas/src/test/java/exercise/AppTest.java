package exercise;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

// BEGIN
class AppTest {

    @Test
    void enlargeArrayImageWhenEmptyInput() {
        assertThat(App.enlargeArrayImage(new String[][] {}))
                .isEmpty();
    }

    @Test
    void enlargeArrayImageWhenNormalInput() {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"}
        };
        String[][] upscaledImage = {
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"}
        };

        List<String> expected = Stream.of(upscaledImage)
                                      .flatMap(Stream::of)
                                      .toList();
        List<String> actual = Stream.of(App.enlargeArrayImage(image))
                                    .flatMap(Stream::of)
                                    .toList();

        assertThat(actual)
                .isEqualTo(expected);
    }
}
// END
