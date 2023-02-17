package ru.voidcyborg.jttag.tags;

import ru.voidcyborg.jttag.tag.DataType;
import ru.voidcyborg.jttag.tag.TagNode;
import ru.voidcyborg.jttag.Utils;

import java.nio.charset.StandardCharsets;

public final class StringNode extends TagNode<String> {

    private final String value;

    StringNode(String value) {
        this.value = value;
    }

    @Override
    public byte[] toBytes() {
        if (value == null) return Utils.uniteBytes(DataType.STRING.toBytes(), Utils.intToBytes(-1));

        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
        return Utils.uniteBytes(DataType.STRING.toBytes(), Utils.intToBytes(bytes.length), bytes);
    }

    @Override
    public DataType getType() {
        return DataType.STRING;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        if (value == null) return -1;
        return value.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof StringNode node) {
            return node.toString().equals(this.toString());
        }
        return false;
    }

    @Override
    public String toString() {
        if (value == null) return "null";
        return "\"" + Utils.toJSON(value) + "\"";
    }

    @Override
    public String toJson(long tabs) {
        return this.toString();
    }
}
