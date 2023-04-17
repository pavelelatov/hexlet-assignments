package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {

    public static Map<String, String> genDiff(
            Map<String, Object> prev,
            Map<String, Object> last) {
        Set<String> keys = new TreeSet<>(prev.keySet());
        keys.addAll(last.keySet());

        Map<String, String> result = new LinkedHashMap<>();

        keys.forEach(key -> result.put(key, getDiff(prev.get(key), last.get(key))));

        return result;
    }

    private static String getDiff(
            Object a,
            Object b) {
        if (a == null && b == null) {
            return "unchanged";
        }

        if (a == null) {
            return "added";
        }

        if (b == null) {
            return "deleted";
        }

        if (a.equals(b)) {
            return "unchanged";
        }

        return "changed";
    }
}
//END
