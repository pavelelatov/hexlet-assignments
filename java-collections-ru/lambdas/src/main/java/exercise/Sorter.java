package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

// BEGIN
class Sorter {

    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        return users.stream()
                    .filter(user -> "male".equals(user.get("gender")))
                    .sorted(Comparator.comparing(user -> user.get("birthday")))
                    .map(user -> user.get("name"))
                    .toList();
    }
}
// END
