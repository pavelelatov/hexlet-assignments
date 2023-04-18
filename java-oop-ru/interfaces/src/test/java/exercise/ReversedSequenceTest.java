package exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ReversedSequenceTest {

    @Test
    void reversedSequence() {
        CharSequence text = new ReversedSequence("abcdef");
        assertEquals("fedcba", text.toString());
        assertEquals('e', text.charAt(1));
        assertEquals(6, text.length());
        assertEquals("edc", text.subSequence(1, 4).toString());
    }
}
