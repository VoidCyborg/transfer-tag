package ru.voidcyborg.jttag.parser;

import ru.voidcyborg.jttag.Utils;
import ru.voidcyborg.jttag.tag.DataType;
import ru.voidcyborg.jttag.tag.Tag;
import ru.voidcyborg.jttag.tag.TransferTag;
import ru.voidcyborg.jttag.tags.*;

import java.nio.charset.StandardCharsets;
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

    public static Tag arrayTag(DataType type, int size, byte[] bytes) throws DataFormatException {
        switch (type) {
            case TAG_ARRAY -> {
                //TODO
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
                byte[] temp = new byte[Short.BYTES];

                int index = 0;
                for (int i = 0; i < size; i += Short.BYTES) {
                    System.arraycopy(bytes, i, temp, 0, temp.length);
                    array[index] = Utils.bytesToShort(temp);
                    index++;
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
                byte[] temp = new byte[Integer.BYTES];

                int index = 0;
                for (int i = 0; i < size; i += Integer.BYTES) {
                    System.arraycopy(bytes, i, temp, 0, temp.length);
                    array[index] = Utils.bytesToInt(temp);
                    index++;
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
                byte[] temp = new byte[Long.BYTES];

                int index = 0;
                for (int i = 0; i < size; i += Long.BYTES) {
                    System.arraycopy(bytes, i, temp, 0, temp.length);
                    array[index] = Utils.bytesToLong(temp);
                    index++;
                }

                return new LongArrayNode(array);

            }
            case FLOAT_ARRAY -> {

            }
            case DOUBLE_ARRAY -> {

            }
            case CHARACTER_ARRAY -> {

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

    public static Tag stringTag(byte[] bytes) throws DataFormatException {
        if (bytes == null) throw new DataFormatException("Bytes can't be null");
        return new StringNode(new String(bytes, StandardCharsets.UTF_8));
    }
}
