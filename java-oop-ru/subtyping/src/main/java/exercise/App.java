package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// BEGIN
public class App {

    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> data = storage.toMap();
        Map<String, String> temp = new HashMap<>();
        Set<String> keys = data.keySet();

        data.forEach((k, v) -> temp.put(v, k));

        keys.forEach(storage::unset);
        temp.forEach(storage::set);
    }
}
// END
