package ru.voidcyborg.jttag.tag;

public enum DataType {
    TAG(false, false),
    TAG_ARRAY(false, true),
    BOOLEAN(true, false),
    BOOLEAN_ARRAY(true, true),
    BYTE(true, false),
    BYTE_ARRAY(true, true),
    SHORT,
    SHORT_ARRAY,
    INTEGER,
    INTEGER_ARRAY,
    LONG,
    LONG_ARRAY,
    FLOAT,
    FLOAT_ARRAY,
    DOUBLE,
    DOUBLE_ARRAY,
    CHARACTER,
    CHARACTER_ARRAY,
    STRING,
    STRING_ARRAY;


    private final boolean primitive;
    private final boolean array;

    DataType(boolean primitive, boolean array) {
        this.primitive = primitive;
        this.array = array;
    }


    public final boolean isPrimitive() {
        return primitive;
    }

    public final boolean isArray() {
        return array;
    }

    public final byte getCode() {
        return (byte) this.ordinal();
    }

    public final byte[] toBytes() {
        return new byte[]{getCode()};
    }

    public static DataType getType(byte code) throws IndexOutOfBoundsException {
        return DataType.values()[code];
    }
}
