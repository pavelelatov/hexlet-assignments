package exercise;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class AppTest {

    private static final List<Integer> EMPTY_LIST = new ArrayList<>();
    private static final List<Integer> FILLED_LIST = List.of(1, 2, 3, 4);

    @Test
    void testTake() {
        assertThat(App.take(EMPTY_LIST, 10))
                .isEmpty();
        assertThat(App.take(FILLED_LIST, 10))
                .hasSize(4)
                .contains(1, 2, 3, 4);
        assertThat(App.take(FILLED_LIST, 3))
                .hasSize(3)
                .contains(1, 2, 3);
        assertThat(App.take(FILLED_LIST, 0))
                .isEmpty();
    }
}
