package exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String chars, String word) {
        List<Character> charsInWord = new ArrayList<>();
        List<Character> availableChars = new LinkedList<>();

        for (char ch : word.toLowerCase().toCharArray()) {
            charsInWord.add(ch);
        }

        for (char ch : chars.toLowerCase().toCharArray()) {
            availableChars.add(ch);
        }

        for (Character ch : charsInWord) {
            if (!availableChars.remove(ch)) {
                return false;
            }
        }

        return true;
    }
}
//END
