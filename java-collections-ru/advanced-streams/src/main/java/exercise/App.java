package exercise;

import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
class App {

    private static final String PREFIX = "X_FORWARDED_";

    public static String getForwardedVariables(String env) {
        return env.lines()
                  .filter(line -> line.startsWith("environment="))
                  .map(line -> line.replace("environment=", ""))
                  .map(line -> line.replace("\"", ""))
                  .map(String::strip)
                  .map(line -> line.split(","))
                  .flatMap(Stream::of)
                  .filter(arg -> arg.startsWith(PREFIX))
                  .map(arg -> arg.replace(PREFIX, ""))
                  .collect(Collectors.joining(","));
    }
}
//END
