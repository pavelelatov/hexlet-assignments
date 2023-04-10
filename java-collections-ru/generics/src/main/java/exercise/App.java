package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// BEGIN
class App {

    public static List<Map<String, String>> findWhere(
            List<Map<String, String>> books,
            Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();

        for (var book : books) {
            boolean matching = true;

            for (var entry : where.entrySet()) {
                if (!book.get(entry.getKey()).equals(entry.getValue())) {
                    matching = false;
                }
            }

            if (matching) {
                result.add(book);
            }
        }

        return result;
    }
}
//END
