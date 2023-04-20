package exercise;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {

    private static final String PAIRED_TAG_TEMPLATE = "<%s%s%s>%s%s</%s>";

    private final String text;
    private final List<Tag> children;

    public PairedTag(
            String name,
            Map<String, String> attributes,
            String text,
            List<Tag> children) {
        super(name, attributes);
        this.text = text;
        this.children = children;
    }

    @Override
    public String toString() {
        var attrs = getAttrs();
        var nestedTags = children.stream()
                                 .map(Tag::toString)
                                 .collect(Collectors.joining(""));
        return String.format(
                PAIRED_TAG_TEMPLATE, name, attrs.isEmpty() ? "" : " ", attrs, text, nestedTags,
                name);
    }
}
// END
