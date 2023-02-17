package ru.voidcyborg.jttag.tags;

import ru.voidcyborg.jttag.Utils;
import ru.voidcyborg.jttag.tag.DataType;
import ru.voidcyborg.jttag.tag.TagNode;

public class CharacterArrayNode extends TagNode<char[]> {
    private final int hashCode;
    private final char[] array;

    CharacterArrayNode(char[] value) {
        array = clone(value);
        hashCode = calcHashCode();
    }


    private char[] clone(char[] array) {
        if (array == null) return null;

        char[] clone = new char[array.length];
        System.arraycopy(array, 0, clone, 0, clone.length);
        return clone;
    }

    private int calcHashCode() {
        if (array == null) return -1;
        int hash = 0;
        for (char value : array) {
            hash += value;
        }
        return hash;
    }

    @Override
    public DataType getType() {
        return DataType.CHARACTER_ARRAY;
    }

    @Override
    public char[] getValue() {
        return clone(array);
    }

    @Override
    public byte[] toBytes() {
        if (array == null) return Utils.uniteBytes(DataType.CHARACTER_ARRAY.toBytes(), Utils.intToBytes(-1));

        byte[][] nodes = new byte[array.length][];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = Utils.charToBytes(array[i]);
        }
        byte[] bytes = Utils.uniteBytes(nodes);

        return Utils.uniteBytes(DataType.CHARACTER_ARRAY.toBytes(), Utils.intToBytes(bytes.length), bytes);
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof CharacterArrayNode arrayNode) {
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
        for (char value : array) {
            builder.append('\"').append(Utils.toJSON(value)).append('\"');
            if (many) builder.append(',');
        }
        if (many) builder.deleteCharAt(builder.length() - 1);
        builder.append(']');
        return builder.toString();
    }

    @Override
    public String toJson(long tabs) {
        return this.toString();//TODO
    }
}
