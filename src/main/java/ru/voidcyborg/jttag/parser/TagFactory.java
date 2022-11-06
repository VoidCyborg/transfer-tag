package ru.voidcyborg.jttag.parser;

import ru.voidcyborg.jttag.Utils;
import ru.voidcyborg.jttag.tag.DataType;
import ru.voidcyborg.jttag.tag.Tag;
import ru.voidcyborg.jttag.tag.TransferTag;
import ru.voidcyborg.jttag.tags.*;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

public class TagFactory {

    /**
     * Массив должен включать только данные этого тега, тип и размер проверяется до вызова данного метода.
     * <p>byte[1] type + byte[fixed] data</p>
     * <p>byte[1] type + byte[4] size + byte[size] data</p>
     * TransferTag tag = TagFactory.transferTag(bytes);
     */
    public static TransferTag transferTag(byte[] bytes) {
        return null;//TODO
    }


    /**
     * Массив должен включать только данные этого тега, тип и размер проверяется до вызова данного метода.
     * <p>byte[1] type + byte[4] size + byte[size] data</p>
     * TransferTag tag = TagFactory.transferTag(bytes);
     */
    public static Tag arrayTag(DataType type, int size, byte[] bytes) throws DataFormatException {
        if (type == null) throw new DataFormatException("Data type can't be null");
        if (!type.isArray()) throw new DataFormatException("This is not array tag " + type);
        switch (type) {
            case TAG_ARRAY -> {
                //TODO
                /*if (bytes == null) return new Transfer(null);
                if (size < 0) throw new DataFormatException("Size of array can't be smaller than 0 - " + size);
                if (size != bytes.length)
                    throw new DataFormatException("Wrong array size " + size + " and " + bytes.length);

                List<String> values = new ArrayList<>();
                ByteBuffer buffer = ByteBuffer.wrap(bytes);

                DataType valueType;
                byte[] data;
                int valueSize;


                while (buffer.hasRemaining()) {
                    valueType = DataType.getType(buffer.get());
                    if (valueType != DataType.STRING)
                        throw new DataFormatException("Wrong content of String_Array " + type);

                    valueSize = buffer.getInt();
                    if (valueSize == -1) {
                        values.add(null);
                        continue;
                    }
                    if (valueSize < 0) throw new DataFormatException("Wrong content bytes size " + valueSize);

                    data = new byte[valueSize];
                    buffer.get(data);

                    values.add(new String(data, StandardCharsets.UTF_8));
                }

                return new StringArrayNode(values.toArray(new String[0]));*/
            }
            case BOOLEAN_ARRAY -> {
                if (bytes == null) return new BooleanArrayNode(null);
                if (size < 0) throw new DataFormatException("Size of array can't be smaller than 0 - " + size);
                if (size != bytes.length)
                    throw new DataFormatException("Wrong array size " + size + " and " + bytes.length);

                boolean[] array = new boolean[size];
                for (int i = 0; i < size; i++) {
                    array[i] = Utils.byteToBoolean(bytes[i]);
                }
                return new BooleanArrayNode(array);
            }
            case BYTE_ARRAY -> {
                if (bytes == null) return new ByteArrayNode(null);
                if (size < 0) throw new DataFormatException("Size of array can't be smaller than 0 - " + size);
                if (size != bytes.length)
                    throw new DataFormatException("Wrong array size " + size + " and " + bytes.length);

                return new ByteArrayNode(bytes);
            }
            case SHORT_ARRAY -> {
                if (bytes == null) return new ShortArrayNode(null);
                if (size < 0) throw new DataFormatException("Size of array can't be smaller than 0 - " + size);
                if (size != bytes.length)
                    throw new DataFormatException("Wrong array size " + size + " and " + bytes.length);
                if (size % Short.BYTES != 0)
                    throw new DataFormatException("Wrong array size " + size + " should divide by " + Short.BYTES);

                short[] array = new short[size / Short.BYTES];
                ByteBuffer buffer = ByteBuffer.wrap(bytes);

                for (int i = 0; buffer.hasRemaining(); i++) {
                    array[i] = buffer.getShort();
                }

                return new ShortArrayNode(array);
            }
            case INTEGER_ARRAY -> {
                if (bytes == null) return new IntegerArrayNode(null);
                if (size < 0) throw new DataFormatException("Size of array can't be smaller than 0 - " + size);
                if (size != bytes.length)
                    throw new DataFormatException("Wrong array size " + size + " and " + bytes.length);
                if (size % Integer.BYTES != 0)
                    throw new DataFormatException("Wrong array size " + size + " should divide by " + Integer.BYTES);

                int[] array = new int[size / Integer.BYTES];
                ByteBuffer buffer = ByteBuffer.wrap(bytes);

                for (int i = 0; buffer.hasRemaining(); i++) {
                    array[i] = buffer.getInt();
                }

                return new IntegerArrayNode(array);
            }
            case LONG_ARRAY -> {
                if (bytes == null) return new LongArrayNode(null);
                if (size < 0) throw new DataFormatException("Size of array can't be smaller than 0 - " + size);
                if (size != bytes.length)
                    throw new DataFormatException("Wrong array size " + size + " and " + bytes.length);
                if (size % Long.BYTES != 0)
                    throw new DataFormatException("Wrong array size " + size + " should divide by " + Long.BYTES);

                long[] array = new long[size / Long.BYTES];
                ByteBuffer buffer = ByteBuffer.wrap(bytes);

                for (int i = 0; buffer.hasRemaining(); i++) {
                    array[i] = buffer.getLong();
                }

                return new LongArrayNode(array);
            }
            case FLOAT_ARRAY -> {
                if (bytes == null) return new FloatArrayNode(null);
                if (size < 0) throw new DataFormatException("Size of array can't be smaller than 0 - " + size);
                if (size != bytes.length)
                    throw new DataFormatException("Wrong array size " + size + " and " + bytes.length);
                if (size % Float.BYTES != 0)
                    throw new DataFormatException("Wrong array size " + size + " should divide by " + Float.BYTES);

                float[] array = new float[size / Float.BYTES];
                ByteBuffer buffer = ByteBuffer.wrap(bytes);

                for (int i = 0; buffer.hasRemaining(); i++) {
                    array[i] = buffer.getFloat();
                }

                return new FloatArrayNode(array);
            }
            case DOUBLE_ARRAY -> {
                if (bytes == null) return new DoubleArrayNode(null);
                if (size < 0) throw new DataFormatException("Size of array can't be smaller than 0 - " + size);
                if (size != bytes.length)
                    throw new DataFormatException("Wrong array size " + size + " and " + bytes.length);
                if (size % Double.BYTES != 0)
                    throw new DataFormatException("Wrong array size " + size + " should divide by " + Double.BYTES);

                double[] array = new double[size / Double.BYTES];
                ByteBuffer buffer = ByteBuffer.wrap(bytes);

                for (int i = 0; buffer.hasRemaining(); i++) {
                    array[i] = buffer.getDouble();
                }

                return new DoubleArrayNode(array);
            }
            case CHARACTER_ARRAY -> {
                if (bytes == null) return new CharacterArrayNode(null);
                if (size < 0) throw new DataFormatException("Size of array can't be smaller than 0 - " + size);
                if (size != bytes.length)
                    throw new DataFormatException("Wrong array size " + size + " and " + bytes.length);
                if (size % Character.BYTES != 0)
                    throw new DataFormatException("Wrong array size " + size + " should divide by " + Character.BYTES);

                char[] array = new char[size / Character.BYTES];
                ByteBuffer buffer = ByteBuffer.wrap(bytes);

                for (int i = 0; buffer.hasRemaining(); i++) {
                    array[i] = buffer.getChar();
                }

                return new CharacterArrayNode(array);
            }
            case STRING_ARRAY -> {
                if (bytes == null) return new StringArrayNode(null);
                if (size < 0) throw new DataFormatException("Size of array can't be smaller than 0 - " + size);
                if (size != bytes.length)
                    throw new DataFormatException("Wrong array size " + size + " and " + bytes.length);

                List<String> values = new ArrayList<>();
                ByteBuffer buffer = ByteBuffer.wrap(bytes);

                DataType valueType;
                byte[] data;
                int valueSize;


                while (buffer.hasRemaining()) {
                    valueType = DataType.getType(buffer.get());
                    if (valueType != DataType.STRING)
                        throw new DataFormatException("Wrong content of String_Array " + type);

                    valueSize = buffer.getInt();
                    if (valueSize == -1) {
                        values.add(null);
                        continue;
                    }
                    if (valueSize < 0) throw new DataFormatException("Wrong content bytes size " + valueSize);

                    data = new byte[valueSize];
                    buffer.get(data);

                    values.add(new String(data, StandardCharsets.UTF_8));
                }

                return new StringArrayNode(values.toArray(new String[0]));
            }
        }
        throw new DataFormatException("Unknown data type - " + type);
    }

    public static Tag primitiveTag(DataType type, byte[] bytes) throws DataFormatException, IllegalArgumentException {
        if (bytes == null) throw new DataFormatException("Bytes can't be null");
        switch (type) {
            case BOOLEAN -> {
                return new BooleanNode(Utils.bytesToBoolean(bytes));
            }
            case BYTE -> {
                return new ByteNode(bytes[0]);
            }
            case SHORT -> {
                return new ShortNode(Utils.bytesToShort(bytes));
            }
            case INTEGER -> {
                return new IntegerNode(Utils.bytesToInt(bytes));
            }
            case LONG -> {
                return new LongNode(Utils.bytesToLong(bytes));
            }
            case FLOAT -> {
                return new FloatNode(Utils.bytesToFloat(bytes));
            }
            case DOUBLE -> {
                return new DoubleNode(Utils.bytesToDouble(bytes));
            }
            case CHARACTER -> {
                return new CharacterNode(Utils.bytesToChar(bytes));
            }
            default -> throw new DataFormatException("Unknown data type - " + type);
        }
    }

    public static StringNode stringTag(int size, byte[] bytes) throws DataFormatException {
        if (bytes == null) return new StringNode(null);

        if (size < 0) throw new DataFormatException("Size of array can't be smaller than 0 - " + size);
        if (size != bytes.length) throw new DataFormatException("Wrong array size " + size + " and " + bytes.length);

        return new StringNode(new String(bytes, StandardCharsets.UTF_8));
    }
}
