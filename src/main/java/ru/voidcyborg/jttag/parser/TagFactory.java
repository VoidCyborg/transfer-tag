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
     * Tag tag = Tag
     */
    public static TransferTag transferTag(byte[] bytes) {
        return null;//TODO
    }

    public static Tag arrayTag(DataType type, byte[] bytes) {
        return null;//TODO
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
