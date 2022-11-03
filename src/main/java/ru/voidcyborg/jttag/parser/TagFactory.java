package ru.voidcyborg.jttag.parser;

import ru.voidcyborg.jttag.tag.DataType;
import ru.voidcyborg.jttag.tag.Tag;
import ru.voidcyborg.jttag.tag.TransferTag;
import ru.voidcyborg.jttag.tags.StringNode;

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

    }

    public static Tag arrayTag(DataType type, byte[] bytes) {

    }

    public static Tag primitiveTag(DataType type, byte[] bytes) {


    }

    public static Tag stringTag(byte[] bytes) throws DataFormatException {
        if (bytes == null) throw new DataFormatException("Bytes can't be null");
        return new StringNode(new String(bytes, StandardCharsets.UTF_8));
    }
}
