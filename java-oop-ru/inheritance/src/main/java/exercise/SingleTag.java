package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    private static final String SINGLE_TAG_TEMPLATE = "<%s%s%s>";

    public SingleTag(
            String name,
            Map<String, String> attributes) {
        super(name, attributes);
    }

    @Override
    public String toString() {
        String attrs = getAttrs();
        return String.format(SINGLE_TAG_TEMPLATE, name, attrs.isEmpty() ? "" : " ", attrs);
    }
}
// END
