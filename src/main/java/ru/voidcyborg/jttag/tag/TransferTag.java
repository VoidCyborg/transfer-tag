package ru.voidcyborg.jttag.tag;

import ru.voidcyborg.jttag.Utils;
import ru.voidcyborg.jttag.tags.*;

import java.util.HashMap;
import java.util.Map;

public final class TransferTag implements Tag {

    private final Map<StringNode, Tag> map;

    public TransferTag() {
        this.map = new HashMap<>();
    }

    TransferTag(HashMap<StringNode, Tag> map) {
        this.map = map;
    }

    public final synchronized TransferTag putTag(String name) {
        if (name == null) return null;

        TransferTag tag = new TransferTag();
        map.put(new StringNode(name), tag);

        return tag;
    }

    public final synchronized TransferTag getTag(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TransferTag tt) return tt;
        return null;
    }

    public final synchronized boolean putBoolean(String name, boolean value) {
        if (name == null) return false;
        map.put(new StringNode(name), new BooleanNode(value));
        return true;
    }

    public final synchronized Boolean getBoolean(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.BOOLEAN) {
                Object o = node.getValue();
                if (o instanceof Boolean b) return b;
            }
        }
        return null;
    }

    public final synchronized boolean putBooleanArray(String name, boolean[] array) {
        if (name == null) return false;
        map.put(new StringNode(name), new BooleanArrayNode(array));
        return true;
    }

    public final synchronized boolean[] getBooleanArray(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.BOOLEAN_ARRAY) {
                Object o = node.getValue();
                if (o instanceof boolean[] array) return array;
            }
        }
        return null;
    }

    public final synchronized boolean putByte(String name, byte value) {
        if (name == null) return false;
        map.put(new StringNode(name), new ByteNode(value));
        return true;
    }

    public final synchronized Byte getByte(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.BYTE) {
                Object o = node.getValue();
                if (o instanceof Byte b) return b;
            }
        }
        return null;
    }

    public final synchronized boolean putByteArray(String name, byte[] array) {
        if (name == null) return false;
        map.put(new StringNode(name), new ByteArrayNode(array));
        return true;
    }

    public final synchronized byte[] getByteArray(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.BYTE_ARRAY) {
                Object o = node.getValue();
                if (o instanceof byte[] array) return array;
            }
        }
        return null;
    }

    public final synchronized boolean putShort(String name, short value) {
        if (name == null) return false;
        map.put(new StringNode(name), new ShortNode(value));
        return true;
    }

    public final synchronized Short getShort(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.SHORT) {
                Object o = node.getValue();
                if (o instanceof Short s) return s;
            }
        }
        return null;
    }

    public final synchronized boolean putShortArray(String name, short[] array) {
        if (name == null) return false;
        map.put(new StringNode(name), new ShortArrayNode(array));
        return true;
    }

    public final synchronized short[] getShortArray(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.SHORT_ARRAY) {
                Object o = node.getValue();
                if (o instanceof short[] array) return array;
            }
        }
        return null;
    }

    public final synchronized boolean putInt(String name, int value) {
        if (name == null) return false;
        map.put(new StringNode(name), new IntegerNode(value));
        return true;
    }

    public final synchronized Integer getInt(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.INTEGER) {
                Object o = node.getValue();
                if (o instanceof Integer i) return i;
            }
        }
        return null;
    }

    public final synchronized boolean putIntArray(String name, int[] array) {
        if (name == null) return false;
        map.put(new StringNode(name), new IntegerArrayNode(array));
        return true;
    }

    public final synchronized int[] getIntArray(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.INTEGER_ARRAY) {
                Object o = node.getValue();
                if (o instanceof int[] array) return array;
            }
        }
        return null;
    }

    public final synchronized boolean putLong(String name, long value) {
        if (name == null) return false;
        map.put(new StringNode(name), new LongNode(value));
        return true;
    }

    public final synchronized Long getLong(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.LONG) {
                Object o = node.getValue();
                if (o instanceof Long l) return l;
            }
        }
        return null;
    }

    public final synchronized boolean putLongArray(String name, long[] array) {
        if (name == null) return false;
        map.put(new StringNode(name), new LongArrayNode(array));
        return true;
    }

    public final synchronized long[] getLongArray(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.LONG_ARRAY) {
                Object o = node.getValue();
                if (o instanceof long[] array) return array;
            }
        }
        return null;
    }

    public final synchronized boolean putFloat(String name, float value) {
        if (name == null) return false;
        map.put(new StringNode(name), new FloatNode(value));
        return true;
    }

    public final synchronized Float getFloat(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.FLOAT) {
                Object o = node.getValue();
                if (o instanceof Float f) return f;
            }
        }
        return null;
    }

    public final synchronized boolean putFloatArray(String name, float[] array) {
        if (name == null) return false;
        map.put(new StringNode(name), new FloatArrayNode(array));
        return true;
    }

    public final synchronized float[] getFloatArray(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.FLOAT_ARRAY) {
                Object o = node.getValue();
                if (o instanceof float[] array) return array;
            }
        }
        return null;
    }

    public final synchronized boolean putDouble(String name, double value) {
        if (name == null) return false;
        map.put(new StringNode(name), new DoubleNode(value));
        return true;
    }

    public final synchronized Double getDouble(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.DOUBLE) {
                Object o = node.getValue();
                if (o instanceof Double f) return f;
            }
        }
        return null;
    }

    public final synchronized boolean putDoubleArray(String name, double[] array) {
        if (name == null) return false;
        map.put(new StringNode(name), new DoubleArrayNode(array));
        return true;
    }

    public final synchronized double[] getDoubleArray(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.DOUBLE_ARRAY) {
                Object o = node.getValue();
                if (o instanceof double[] array) return array;
            }
        }
        return null;
    }

    public final synchronized boolean putChar(String name, char value) {
        if (name == null) return false;
        map.put(new StringNode(name), new CharacterNode(value));
        return true;
    }

    public final synchronized Character getChar(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.CHARACTER) {
                Object o = node.getValue();
                if (o instanceof Character c) return c;
            }
        }
        return null;
    }

    public final synchronized boolean putCharArray(String name, char[] array) {
        if (name == null) return false;
        map.put(new StringNode(name), new CharacterArrayNode(array));
        return true;
    }

    public final synchronized char[] getCharArray(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.CHARACTER_ARRAY) {
                Object o = node.getValue();
                if (o instanceof char[] array) return array;
            }
        }
        return null;
    }

    public final synchronized boolean putString(String name, String value) {
        if (name == null) return false;
        map.put(new StringNode(name), new StringNode(value));
        return true;
    }

    public final synchronized String getString(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.STRING) {
                Object o = node.getValue();
                if (o instanceof String s) return s;
            }
        }
        return null;
    }

    public final synchronized boolean putStringArray(String name, String[] array) {
        if (name == null) return false;
        map.put(new StringNode(name), new StringArrayNode(array));
        return true;
    }

    public final synchronized String[] getStringArray(String name) {
        if (name == null) return null;

        Tag tag = map.get(new StringNode(name));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.STRING_ARRAY) {
                Object o = node.getValue();
                if (o instanceof String[] array) return array;
            }
        }
        return null;
    }

    @Override
    public final synchronized byte[] toBytes() {
        int index = 0;
        byte[][] array = new byte[map.size() * 2][];
        for (Map.Entry<StringNode, Tag> entry : map.entrySet()) {
            array[index] = entry.getKey().toBytes();
            array[index + 1] = entry.getValue().toBytes();
            index += 2;
        }

        byte[] bytes = Utils.uniteBytes(array);

        return Utils.uniteBytes(DataType.TAG.toBytes(), Utils.intToBytes(bytes.length), bytes);
    }

    @Override
    public final synchronized int hashCode() {
        return map.hashCode();
    }

    @Override
    public final synchronized boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof TransferTag tag) {
            for (Map.Entry<StringNode, Tag> entry : map.entrySet()) {
                Tag value = tag.map.get(entry.getKey());

                if (value == null && entry.getValue() == null) continue;
                if (value == null || entry.getValue() == null) return false;
                if (!value.equals(entry.getValue())) return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public final synchronized String toString() {
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
}
