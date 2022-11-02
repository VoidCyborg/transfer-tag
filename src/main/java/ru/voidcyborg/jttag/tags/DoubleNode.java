package ru.voidcyborg.jttag.tags;

import ru.voidcyborg.jttag.Utils;
import ru.voidcyborg.jttag.tag.DataType;
import ru.voidcyborg.jttag.tag.TagNode;

public class DoubleNode extends TagNode<Double> {
    private final double value;

    public DoubleNode(double value) {
        this.value = value;
    }

    @Override
    public byte[] toBytes() {
        return Utils.uniteBytes(DataType.DOUBLE.toBytes(), Utils.doubleToBytes(value));
    }

    @Override
    public DataType getType() {
        return DataType.DOUBLE;
    }

    @Override
    public Double getValue() {
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
        if (o instanceof DoubleNode node) {
            return this.value == node.value;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
