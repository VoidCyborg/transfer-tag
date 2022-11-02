package ru.voidcyborg.jttag.tags;

import ru.voidcyborg.jttag.Utils;
import ru.voidcyborg.jttag.tag.DataType;
import ru.voidcyborg.jttag.tag.TagNode;

public final class ShortNode extends TagNode<Short> {

    private final short value;

    public ShortNode(short value) {
        this.value = value;
    }

    @Override
    public byte[] toBytes() {
        return Utils.uniteBytes(DataType.SHORT.toBytes(), Utils.shortToBytes(value));
    }

    @Override
    public DataType getType() {
        return DataType.SHORT;
    }

    @Override
    public Short getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof ShortNode node) {
            return this.value == node.value;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
