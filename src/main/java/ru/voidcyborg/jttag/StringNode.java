package ru.voidcyborg.jttag;

import java.nio.charset.StandardCharsets;

public class StringNode extends TagNode<String> {

    protected StringNode(String value) {
        super(value);
    }

    @Override
    public byte[] toBytes() {
        byte[] bytes = getValue().getBytes(StandardCharsets.UTF_8);
        return ByteUtils.uniteBytes(DataType.STRING.toBytes(), ByteUtils.intToBytes(bytes.length), bytes);
    }

    @Override
    public int hashCode() {
        return getValue().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof StringNode node) {
            return node.getValue().equals(this.getValue());
        }
        return false;
    }

    @Override
    public String toString() {
        return "\"" + getValue() + "\"";
    }
}
