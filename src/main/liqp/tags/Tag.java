package liqp.tags;

import liqp.nodes.LNode;

import java.util.HashMap;
import java.util.Map;

public abstract class Tag {

    private static final Map<String, Tag> TAGS = new HashMap<String, Tag>();

    static {
        registerTag(new assign());
    }

    public static Tag getTag(String name) {

        Tag tag = TAGS.get(name);

        if(tag == null) {
            throw new RuntimeException("unknown tag: " + name);
        }

        return tag;
    }

    private static void registerTag(Tag tag) {
        registerTag(tag.getClass().getSimpleName(), tag);
    }

    public static void registerTag(String name, Tag tag) {
        TAGS.put(name, tag);
    }

    public abstract Object render(Map<String, Object> variables, LNode... tokens);
}
