package ru.voidcyborg.jttag.tags;

import ru.voidcyborg.jttag.Utils;
import ru.voidcyborg.jttag.tag.DataType;
import ru.voidcyborg.jttag.tag.TagNode;


public final class StringArrayNode extends TagNode<String[]> {

    private final int hashCode;
    private final StringNode[] nodeArray;
    private final String[] array;

    public StringArrayNode(String[] value) {
        array = clone(value);
        nodeArray = fill(array);
        hashCode = calcHashCode();
    }


    private String[] clone(String[] array) {
        if (array == null) return null;

        String[] clone = new String[array.length];
        System.arraycopy(array, 0, clone, 0, clone.length);
        return clone;
    }

    private StringNode[] fill(String[] array) {
        if (array == null) return null;

        StringNode[] nodes = new StringNode[array.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new StringNode(array[i]);
        }
        return nodes;
    }

    private int calcHashCode() {
        if (nodeArray == null) return -1;
        return nodeArray.length * 50;
    }

    @Override
    public DataType getType() {
        return DataType.STRING_ARRAY;
    }

    @Override
    public String[] getValue() {
        return clone(array);
    }

    @Override
    public byte[] toBytes() {
        if (nodeArray == null) return Utils.uniteBytes(DataType.STRING_ARRAY.toBytes(), Utils.intToBytes(-1));

        byte[][] nodes = new byte[nodeArray.length][];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = nodeArray[i].toBytes();
        }
        byte[] bytes = Utils.uniteBytes(nodes);

        return Utils.uniteBytes(DataType.STRING_ARRAY.toBytes(), Utils.intToBytes(bytes.length), bytes);
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof StringArrayNode arrayNode) {
            if (arrayNode.nodeArray == null && this.nodeArray == null) return true;
            if (arrayNode.nodeArray == null || this.nodeArray == null) return false;

            if (arrayNode.nodeArray.length != this.nodeArray.length) return false;
            for (int i = 0; i < this.nodeArray.length; i++) {
                if (!this.nodeArray[i].equals(arrayNode.nodeArray[i])) return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (nodeArray == null) return "null";
        StringBuilder builder = new StringBuilder().append('[');

        boolean many = nodeArray.length > 1;
        for (StringNode node : nodeArray) {
            builder.append(node.toString());
            if (many) builder.append(',');
        }
        if (many) builder.deleteCharAt(builder.length() - 1);
        builder.append(']');
        return builder.toString();
    }
}
