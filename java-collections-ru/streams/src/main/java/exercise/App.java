package exercise;

import java.util.List;

// BEGIN
class App {

    private static final List<String> FREE = List.of("gmail.com", "yandex.ru", "hotmail.com");

    public static long getCountOfFreeEmails(List<String> emails) {
        return emails.stream()
                     .map(email -> email.split("@")[1])
                     .filter(FREE::contains)
                     .count();
    }
}
// END
