package ru.voidcyborg.jttag.tags;

import ru.voidcyborg.jttag.Utils;
import ru.voidcyborg.jttag.tag.DataType;
import ru.voidcyborg.jttag.tag.TagNode;

public class LongNode extends TagNode<Long> {
    private final long value;
    private final int hashCode;

    LongNode(long value) {
        this.value = value;
        this.hashCode = calcHashCode();
    }

    private int calcHashCode() {
        return (int) (value ^ (value >>> 32));
    }

    @Override
    public byte[] toBytes() {
        return Utils.uniteBytes(DataType.LONG.toBytes(), Utils.longToBytes(value));
    }

    @Override
    public DataType getType() {
        return DataType.LONG;
    }

    @Override
    public Long getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof LongNode node) {
            return this.value == node.value;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public String toJson(long tabs) {
        return this.toString();
    }
}
