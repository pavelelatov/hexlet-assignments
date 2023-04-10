package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {

    public static Map<String, Integer> getWordCount(String str) {
        Map<String, Integer> result = new HashMap<>();

        if (str.isBlank()) {
            return result;
        }

        String[] words = str.strip().split(" ");

        for (String word : words) {
            result.put(word, result.getOrDefault(word, 0) + 1);
        }

        return result;
    }

    public static String toString(Map<String, Integer> map) {
        StringBuilder sb = new StringBuilder("{");

        if (!map.isEmpty()) {
            sb.append("\n");
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append("  ");
            sb.append(entry.getKey());
            sb.append(": ");
            sb.append(entry.getValue());
            sb.append("\n");
        }

        sb.append("}");
        return sb.toString();
    }
}
//END
