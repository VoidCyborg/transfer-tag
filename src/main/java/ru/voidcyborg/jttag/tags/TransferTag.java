package ru.voidcyborg.jttag.tags;

import ru.voidcyborg.jttag.Utils;
import ru.voidcyborg.jttag.tag.DataType;
import ru.voidcyborg.jttag.tag.Tag;
import ru.voidcyborg.jttag.tag.TagKey;
import ru.voidcyborg.jttag.tag.TagNode;
import java.util.LinkedHashMap;
import java.util.Map;

public final class TransferTag implements Tag {

    private final Map<TagKey, Tag> map;

    public TransferTag() {
        this.map = new LinkedHashMap<>();
    }

    TransferTag(Map<TagKey, Tag> map) {
        this.map = map;
    }

    public synchronized TransferTag putTag(String name) {
        if (name == null) return null;

        TransferTag tag = new TransferTag();
        map.put(new TagKey(new StringNode(name), DataType.TAG), tag);

        return tag;
    }

    public synchronized TransferTag getTag(String name) {
        if (name == null) return null;

        Tag tag = map.get(new TagKey(new StringNode(name), DataType.TAG));
        if (tag == null) return null;

        if (tag instanceof TransferTag tt) return tt;
        return null;
    }

    public synchronized boolean putBoolean(String name, boolean value) {
        if (name == null) return false;
        map.put(new TagKey(new StringNode(name), DataType.BOOLEAN), new BooleanNode(value));
        return true;
    }

    public synchronized Boolean getBoolean(String name) {
        if (name == null) return null;

        Tag tag = map.get(new TagKey(new StringNode(name), DataType.BOOLEAN));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.BOOLEAN) {
                Object o = node.getValue();
                if (o instanceof Boolean b) return b;
            }
        }
        return null;
    }

    public synchronized boolean putBooleanArray(String name, boolean[] array) {
        if (name == null) return false;
        map.put(new TagKey(new StringNode(name), DataType.BOOLEAN_ARRAY), new BooleanArrayNode(array));
        return true;
    }

    public synchronized boolean[] getBooleanArray(String name) {
        if (name == null) return null;

        Tag tag = map.get(new TagKey(new StringNode(name), DataType.BOOLEAN_ARRAY));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.BOOLEAN_ARRAY) {
                Object o = node.getValue();
                if (o instanceof boolean[] array) return array;
            }
        }
        return null;
    }

    public synchronized boolean putByte(String name, byte value) {
        if (name == null) return false;
        map.put(new TagKey(new StringNode(name), DataType.BYTE), new ByteNode(value));
        return true;
    }

    public synchronized Byte getByte(String name) {
        if (name == null) return null;

        Tag tag = map.get(new TagKey(new StringNode(name), DataType.BYTE));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.BYTE) {
                Object o = node.getValue();
                if (o instanceof Byte b) return b;
            }
        }
        return null;
    }

    public synchronized boolean putByteArray(String name, byte[] array) {
        if (name == null) return false;
        map.put(new TagKey(new StringNode(name), DataType.BYTE_ARRAY), new ByteArrayNode(array));
        return true;
    }

    public synchronized byte[] getByteArray(String name) {
        if (name == null) return null;

        Tag tag = map.get(new TagKey(new StringNode(name), DataType.BYTE_ARRAY));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.BYTE_ARRAY) {
                Object o = node.getValue();
                if (o instanceof byte[] array) return array;
            }
        }
        return null;
    }

    public synchronized boolean putShort(String name, short value) {
        if (name == null) return false;
        map.put(new TagKey(new StringNode(name), DataType.SHORT), new ShortNode(value));
        return true;
    }

    public synchronized Short getShort(String name) {
        if (name == null) return null;

        Tag tag = map.get(new TagKey(new StringNode(name), DataType.SHORT));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.SHORT) {
                Object o = node.getValue();
                if (o instanceof Short s) return s;
            }
        }
        return null;
    }

    public synchronized boolean putShortArray(String name, short[] array) {
        if (name == null) return false;
        map.put(new TagKey(new StringNode(name), DataType.SHORT_ARRAY), new ShortArrayNode(array));
        return true;
    }

    public synchronized short[] getShortArray(String name) {
        if (name == null) return null;

        Tag tag = map.get(new TagKey(new StringNode(name), DataType.SHORT_ARRAY));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.SHORT_ARRAY) {
                Object o = node.getValue();
                if (o instanceof short[] array) return array;
            }
        }
        return null;
    }

    public synchronized boolean putInt(String name, int value) {
        if (name == null) return false;
        map.put(new TagKey(new StringNode(name), DataType.INTEGER), new IntegerNode(value));
        return true;
    }

    public synchronized Integer getInt(String name) {
        if (name == null) return null;

        Tag tag = map.get(new TagKey(new StringNode(name), DataType.INTEGER));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.INTEGER) {
                Object o = node.getValue();
                if (o instanceof Integer i) return i;
            }
        }
        return null;
    }

    public synchronized boolean putIntArray(String name, int[] array) {
        if (name == null) return false;
        map.put(new TagKey(new StringNode(name), DataType.INTEGER_ARRAY), new IntegerArrayNode(array));
        return true;
    }

    public synchronized int[] getIntArray(String name) {
        if (name == null) return null;

        Tag tag = map.get(new TagKey(new StringNode(name), DataType.INTEGER_ARRAY));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.INTEGER_ARRAY) {
                Object o = node.getValue();
                if (o instanceof int[] array) return array;
            }
        }
        return null;
    }

    public synchronized boolean putLong(String name, long value) {
        if (name == null) return false;
        map.put(new TagKey(new StringNode(name), DataType.LONG), new LongNode(value));
        return true;
    }

    public synchronized Long getLong(String name) {
        if (name == null) return null;

        Tag tag = map.get(new TagKey(new StringNode(name), DataType.LONG));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.LONG) {
                Object o = node.getValue();
                if (o instanceof Long l) return l;
            }
        }
        return null;
    }

    public synchronized boolean putLongArray(String name, long[] array) {
        if (name == null) return false;
        map.put(new TagKey(new StringNode(name), DataType.LONG_ARRAY), new LongArrayNode(array));
        return true;
    }

    public synchronized long[] getLongArray(String name) {
        if (name == null) return null;

        Tag tag = map.get(new TagKey(new StringNode(name), DataType.LONG_ARRAY));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.LONG_ARRAY) {
                Object o = node.getValue();
                if (o instanceof long[] array) return array;
            }
        }
        return null;
    }

    public synchronized boolean putFloat(String name, float value) {
        if (name == null) return false;
        map.put(new TagKey(new StringNode(name), DataType.FLOAT), new FloatNode(value));
        return true;
    }

    public synchronized Float getFloat(String name) {
        if (name == null) return null;

        Tag tag = map.get(new TagKey(new StringNode(name), DataType.FLOAT));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.FLOAT) {
                Object o = node.getValue();
                if (o instanceof Float f) return f;
            }
        }
        return null;
    }

    public synchronized boolean putFloatArray(String name, float[] array) {
        if (name == null) return false;
        map.put(new TagKey(new StringNode(name), DataType.FLOAT_ARRAY), new FloatArrayNode(array));
        return true;
    }

    public synchronized float[] getFloatArray(String name) {
        if (name == null) return null;

        Tag tag = map.get(new TagKey(new StringNode(name), DataType.FLOAT_ARRAY));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.FLOAT_ARRAY) {
                Object o = node.getValue();
                if (o instanceof float[] array) return array;
            }
        }
        return null;
    }

    public synchronized boolean putDouble(String name, double value) {
        if (name == null) return false;
        map.put(new TagKey(new StringNode(name), DataType.DOUBLE), new DoubleNode(value));
        return true;
    }

    public synchronized Double getDouble(String name) {
        if (name == null) return null;

        Tag tag = map.get(new TagKey(new StringNode(name), DataType.DOUBLE));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.DOUBLE) {
                Object o = node.getValue();
                if (o instanceof Double f) return f;
            }
        }
        return null;
    }

    public synchronized boolean putDoubleArray(String name, double[] array) {
        if (name == null) return false;
        map.put(new TagKey(new StringNode(name), DataType.DOUBLE_ARRAY), new DoubleArrayNode(array));
        return true;
    }

    public synchronized double[] getDoubleArray(String name) {
        if (name == null) return null;

        Tag tag = map.get(new TagKey(new StringNode(name), DataType.DOUBLE_ARRAY));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.DOUBLE_ARRAY) {
                Object o = node.getValue();
                if (o instanceof double[] array) return array;
            }
        }
        return null;
    }

    public synchronized boolean putChar(String name, char value) {
        if (name == null) return false;
        map.put(new TagKey(new StringNode(name), DataType.CHARACTER), new CharacterNode(value));
        return true;
    }

    public synchronized Character getChar(String name) {
        if (name == null) return null;

        Tag tag = map.get(new TagKey(new StringNode(name), DataType.CHARACTER));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.CHARACTER) {
                Object o = node.getValue();
                if (o instanceof Character c) return c;
            }
        }
        return null;
    }

    public synchronized boolean putCharArray(String name, char[] array) {
        if (name == null) return false;
        map.put(new TagKey(new StringNode(name), DataType.CHARACTER_ARRAY), new CharacterArrayNode(array));
        return true;
    }

    public synchronized char[] getCharArray(String name) {
        if (name == null) return null;

        Tag tag = map.get(new TagKey(new StringNode(name), DataType.CHARACTER_ARRAY));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.CHARACTER_ARRAY) {
                Object o = node.getValue();
                if (o instanceof char[] array) return array;
            }
        }
        return null;
    }

    public synchronized boolean putString(String name, String value) {
        if (name == null) return false;
        map.put(new TagKey(new StringNode(name), DataType.STRING), new StringNode(value));
        return true;
    }

    public synchronized String getString(String name) {
        if (name == null) return null;

        Tag tag = map.get(new TagKey(new StringNode(name), DataType.STRING));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.STRING) {
                Object o = node.getValue();
                if (o instanceof String s) return s;
            }
        }
        return null;
    }

    public synchronized boolean putStringArray(String name, String[] array) {
        if (name == null) return false;
        map.put(new TagKey(new StringNode(name), DataType.STRING_ARRAY), new StringArrayNode(array));
        return true;
    }

    public synchronized String[] getStringArray(String name) {
        if (name == null) return null;

        Tag tag = map.get(new TagKey(new StringNode(name), DataType.STRING_ARRAY));
        if (tag == null) return null;

        if (tag instanceof TagNode<?> node) {
            if (node.getType() == DataType.STRING_ARRAY) {
                Object o = node.getValue();
                if (o instanceof String[] array) return array;
            }
        }
        return null;
    }

    public synchronized void deleteValue(String name, DataType type) {
        if (name == null || type == null) return;
        map.remove(new TagKey(new StringNode(name), type));
    }

    public synchronized void clearTag(){
        map.clear();
    }

    @Override
    public synchronized byte[] toBytes() {
        int index = 0;
        byte[][] array = new byte[map.size() * 2][];
        for (Map.Entry<TagKey, Tag> entry : map.entrySet()) {
            array[index] = entry.getKey().getKey().toBytes();
            array[index + 1] = entry.getValue().toBytes();
            index += 2;
        }

        byte[] bytes = Utils.uniteBytes(array);

        return Utils.uniteBytes(DataType.TAG.toBytes(), Utils.intToBytes(bytes.length), bytes);
    }

    @Override
    public synchronized int hashCode() {
        return map.hashCode();
    }

    @Override
    public synchronized boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof TransferTag tag) {
            for (Map.Entry<TagKey, Tag> entry : map.entrySet()) {
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
    public synchronized String toString() {
        StringBuilder builder = new StringBuilder().append('{');

        boolean many = map.size() > 1;
        for (Map.Entry<TagKey, Tag> entry : map.entrySet()) {
            builder.append(entry.getKey().getKey()).append(':').append(entry.getValue());
            if (many) builder.append(',');
        }
        if (many) builder.deleteCharAt(builder.length() - 1);
        builder.append('}');

        return builder.toString();
    }

    @Override
    public synchronized String toJson(long tabs) {
        StringBuilder builder = new StringBuilder().append('{').append("\n");

        if(map.size() != 0) Utils.repeat(builder, "    ", tabs+1);
        else Utils.repeat(builder, "    ", tabs);

        int last = 0;

        boolean many = map.size() > 1;
        if (many) last = map.size() - 1;

        int i = 0;
        for (Map.Entry<TagKey, Tag> entry : map.entrySet()) {
            builder.append(entry.getKey().getKey()).append(": ").append(entry.getValue().toJson(tabs + 1));
            if (many) {
                if (i != last) builder.append(',').append("\n").append("    ");
                else builder.append("\n");
            }
            if(!many) builder.append("\n");
            Utils.repeat(builder, "    ", tabs);
            i++;
        }
        builder.append('}');

        return builder.toString();
    }

    public synchronized String toJson() {
        return this.toJson(0);
    }


}
