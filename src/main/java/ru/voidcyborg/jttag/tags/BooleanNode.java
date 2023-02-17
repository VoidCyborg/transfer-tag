package ru.voidcyborg.jttag.tags;

import ru.voidcyborg.jttag.Utils;
import ru.voidcyborg.jttag.tag.DataType;
import ru.voidcyborg.jttag.tag.TagNode;

public final class BooleanNode extends TagNode<Boolean> {

    private final boolean value;
    private final int hashCode;

    BooleanNode(boolean value) {
        this.value = value;
        hashCode = value ? 1 : 0;
    }

    @Override
    public byte[] toBytes() {
        return Utils.uniteBytes(DataType.BOOLEAN.toBytes(), Utils.booleanToBytes(value));
    }

    @Override
    public DataType getType() {
        return DataType.BOOLEAN;
    }

    @Override
    public Boolean getValue() {
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
        if (o instanceof BooleanNode node) {
            return this.value == node.value;
        }
        return false;
    }

    @Override
    public String toString() {
        return value ? "true" : "false";
    }

    @Override
    public String toJson(long tabs) {
        return this.toString();
    }
}
