package ru.voidcyborg.jttag.tags;

import ru.voidcyborg.jttag.Utils;
import ru.voidcyborg.jttag.tag.DataType;
import ru.voidcyborg.jttag.tag.TagNode;

public final class TransferTagArrayNode extends TagNode<TransferTag[]> {

    private final int hashCode;
    private final TransferTag[] nodeArray;

    TransferTagArrayNode(TransferTag[] value) {//Не используется так как может создать цикличное наследование.
        nodeArray = clone(value);
        hashCode = calcHashCode();
    }


    private TransferTag[] clone(TransferTag[] array) {
        if (array == null) return null;

        TransferTag[] clone = new TransferTag[array.length];
        System.arraycopy(array, 0, clone, 0, clone.length);
        return clone;
    }

    private int calcHashCode() {
        if (nodeArray == null) return -1;
        return nodeArray.length * 50;
    }

    @Override
    public DataType getType() {
        return DataType.TAG_ARRAY;
    }

    @Override
    public TransferTag[] getValue() {
        return clone(nodeArray);
    }

    @Override
    public byte[] toBytes() {
        if (nodeArray == null) return Utils.uniteBytes(DataType.TAG_ARRAY.toBytes(), Utils.intToBytes(-1));

        byte[][] nodes = new byte[nodeArray.length][];
        for (int i = 0; i < nodes.length; i++) {
            if (nodeArray[i] == null) nodes[i] = Utils.uniteBytes(DataType.TAG.toBytes(), Utils.intToBytes(-1));
            else nodes[i] = nodeArray[i].toBytes();
        }
        byte[] bytes = Utils.uniteBytes(nodes);

        return Utils.uniteBytes(DataType.TAG_ARRAY.toBytes(), Utils.intToBytes(bytes.length), bytes);
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof TransferTagArrayNode arrayNode) {
            if (arrayNode.nodeArray == null && this.nodeArray == null) return true;
            if (arrayNode.nodeArray == null || this.nodeArray == null) return false;

            if (arrayNode.nodeArray.length != this.nodeArray.length) return false;
            for (int i = 0; i < this.nodeArray.length; i++) {
                if (arrayNode.nodeArray[i] == null && this.nodeArray[i] == null) continue;
                if (arrayNode.nodeArray[i] == null || this.nodeArray[i] == null) return false;

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
        for (TransferTag node : nodeArray) {
            if (node == null) builder.append("null");
            else builder.append(node);
            if (many) builder.append(',');
        }
        if (many) builder.deleteCharAt(builder.length() - 1);
        builder.append(']');
        return builder.toString();
    }

    @Override
    public String toJson(long tabs) {
        if (nodeArray == null) return "null";
        StringBuilder builder = new StringBuilder().append('[').append("\n");

        if(nodeArray.length != 0) Utils.repeat(builder, "    ", tabs+1);
        else Utils.repeat(builder, "    ", tabs);

        int last = 0;

        boolean many = nodeArray.length > 1;
        if(many) last = nodeArray.length-1;

        int i = 0;
        for (TransferTag node : nodeArray) {
            if (node == null) builder.append("null");
            else builder.append(node.toJson(tabs+1));
            if (many) {
                if(i != last) builder.append(',').append("\n").append("    ");
                else builder.append("\n");
            }
            if(!many) builder.append("\n");
            Utils.repeat(builder, "    ", tabs);
            i++;
        }
        builder.append(']');

        return builder.toString();
    }

}
