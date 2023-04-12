package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// BEGIN
class App {

    public static String[][] enlargeArrayImage(String[][] image) {
        List<String[]> test = new ArrayList<>();
        Stream.of(image)
              .map(App::doubleStringArr)
              .forEach(x -> {
                  test.add(x);
                  test.add(x);
              });
        return test.toArray(String[][]::new);
    }

    private static String[] doubleStringArr(String[] arr) {
        String[] result = new String[arr.length * 2];

        for (int i = 0; i < arr.length; i++) {
            result[i * 2] = arr[i];
            result[i * 2 + 1] = arr[i];
        }

        return result;
    }
}
// END
