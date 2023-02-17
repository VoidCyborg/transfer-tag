package ru.voidcyborg.jttag.tags;

import ru.voidcyborg.jttag.Utils;
import ru.voidcyborg.jttag.tag.DataType;
import ru.voidcyborg.jttag.tag.TagNode;

public class FloatNode extends TagNode<Float> {

    private final float value;

    FloatNode(float value) {
        this.value = value;
    }

    @Override
    public byte[] toBytes() {
        return Utils.uniteBytes(DataType.FLOAT.toBytes(), Utils.floatToBytes(value));
    }

    @Override
    public DataType getType() {
        return DataType.FLOAT;
    }

    @Override
    public Float getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return (int) value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof FloatNode node) {
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
