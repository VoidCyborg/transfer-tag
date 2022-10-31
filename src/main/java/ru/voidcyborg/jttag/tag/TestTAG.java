package ru.voidcyborg.jttag.tag;

import ru.voidcyborg.jttag.Utils;
import ru.voidcyborg.jttag.tags.StringNode;

import java.util.HashMap;
import java.util.Map;

public class TestTAG implements Tag {

    private final int hashCode = Integer.MIN_VALUE + (int) (Math.random() * Integer.MAX_VALUE);
    private final Map<StringNode, Tag> map = new HashMap<>();


    public synchronized boolean putTag(String name, TestTAG tag) {
        if (name == null || tag == null) return false;
        map.put(new StringNode(name), tag);
        return true;
    }

    public synchronized TestTAG getTag(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TestTAG hashTag) return hashTag;
        return null;
    }

    public synchronized boolean putString(String name, String value) {
        if (name == null || value == null) return false;
        map.put(new StringNode(name), new StringNode(value));
        return true;
    }

    public synchronized String getString(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getValue() instanceof String s) return s;
        }
        return null;
    }

    @Override
    public synchronized byte[] toBytes() {
        int size = 0;
        byte[][] array = new byte[map.size()][];
        for (Map.Entry<StringNode, Tag> entry : map.entrySet()) {

        }

        return Utils.uniteBytes();
    }


    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof TestTAG tag) {
            for (Map.Entry<StringNode, Tag> entry : map.entrySet()) {
                if (!entry.getValue().equals(tag.map.get(entry.getKey()))) return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public synchronized String toString() {
        StringBuilder builder = new StringBuilder().append('{');

        boolean many = map.size() > 1;
        for (Map.Entry<StringNode, Tag> entry : map.entrySet()) {
            builder.append(entry.getKey()).append(':').append(entry.getValue());
            if (many) builder.append(',');
        }
        if (many) builder.deleteCharAt(builder.length() - 1);
        builder.append('}');

        return builder.toString();
    }




  /*  public boolean putTagArray(String name, Tag[] tags);

    boolean putBoolean(String name, boolean value);

    boolean putBooleanArray(String name, boolean[] array);

    boolean putByte(String name, byte value);

    boolean putByteArray(String name, byte[] array);

    boolean putShort(String name, short value);

    boolean putShortArray(String name, short[] array);

    boolean putInt(String name, int value);

    boolean putIntArray(String name, int[] array);

    boolean putLong(String name, long value);

    boolean putLongArray(String name, long[] array);

    boolean putFloat(String name, float value);

    boolean putFloatArray(String name, float[] array);

    boolean putDouble(String name, double value);

    boolean putDoubleArray(String name, double[] array);

    boolean putString(String name, String value);

    boolean putStringArray(String name, String[] array);*/
}
