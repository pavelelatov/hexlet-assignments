package exercise;

import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public abstract class Tag {

    protected static final String ATTRIBUTE_TEMPLATE = "%s=\"%s\"";

    protected final String name;
    protected final Map<String, String> attributes;

    protected Tag(
            String name,
            Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    protected String getAttrs() {
        return attributes.entrySet().stream()
                         .map(e -> String.format(
                                 ATTRIBUTE_TEMPLATE, e.getKey(), e.getValue()))
                         .collect(Collectors.joining(" "));
    }

    @Override
    public abstract String toString();
}
// END
