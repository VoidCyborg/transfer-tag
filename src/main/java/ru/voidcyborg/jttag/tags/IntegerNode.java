package ru.voidcyborg.jttag.tags;

import ru.voidcyborg.jttag.Utils;
import ru.voidcyborg.jttag.tag.DataType;
import ru.voidcyborg.jttag.tag.TagNode;

public final class IntegerNode extends TagNode<Integer> {

    private final int value;

    IntegerNode(int value) {
        this.value = value;
    }

    @Override
    public byte[] toBytes() {
        return Utils.uniteBytes(DataType.INTEGER.toBytes(), Utils.intToBytes(value));
    }

    @Override
    public DataType getType() {
        return DataType.INTEGER;
    }

    @Override
    public Integer getValue() {
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
        if (o instanceof IntegerNode node) {
            return this.value == node.value;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
