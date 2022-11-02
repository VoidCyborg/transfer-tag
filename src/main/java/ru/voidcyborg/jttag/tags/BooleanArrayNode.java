package ru.voidcyborg.jttag.tags;

import ru.voidcyborg.jttag.Utils;
import ru.voidcyborg.jttag.tag.DataType;
import ru.voidcyborg.jttag.tag.TagNode;

public final class BooleanArrayNode extends TagNode<boolean[]> {
    private final int hashCode;
    private final boolean[] array;

    public BooleanArrayNode(boolean[] value) {
        array = clone(value);
        hashCode = calcHashCode();
    }

    private boolean[] clone(boolean[] array) {
        if (array == null) return null;

        boolean[] clone = new boolean[array.length];
        System.arraycopy(array, 0, clone, 0, clone.length);
        return clone;
    }

    private int calcHashCode() {
        if (array == null) return -1;
        int hash = 0;
        for (boolean value : array) {
            hash += Utils.booleanToBytes(value)[0];
        }
        return hash;
    }

    @Override
    public DataType getType() {
        return DataType.BOOLEAN_ARRAY;
    }

    @Override
    public boolean[] getValue() {
        return clone(array);
    }

    @Override
    public byte[] toBytes() {
        if (array == null) return Utils.uniteBytes(DataType.BOOLEAN_ARRAY.toBytes(), Utils.intToBytes(-1));

        byte[] bytes = new byte[array.length];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = Utils.booleanToBytes(array[i])[0];
        }

        return Utils.uniteBytes(DataType.BOOLEAN_ARRAY.toBytes(), Utils.intToBytes(bytes.length), bytes);
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof BooleanArrayNode arrayNode) {
            if (arrayNode.array == null && this.array == null) return true;
            if (arrayNode.array == null || this.array == null) return false;

            if (arrayNode.array.length != this.array.length) return false;
            for (int i = 0; i < this.array.length; i++) {
                if (this.array[i] != arrayNode.array[i]) return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (array == null) return "null";
        StringBuilder builder = new StringBuilder().append('[');

        boolean many = array.length > 1;
        for (boolean value : array) {
            builder.append(value);
            if (many) builder.append(',');
        }
        if (many) builder.deleteCharAt(builder.length() - 1);
        builder.append(']');
        return builder.toString();
    }
}
