package ru.voidcyborg.jttag.tag;

public enum DataType {
    TAG(false, false, -1),
    TAG_ARRAY(false, true, -1),
    BOOLEAN(true, false, 1),
    BOOLEAN_ARRAY(true, true, -1),
    BYTE(true, false, 1),
    BYTE_ARRAY(true, true, -1),
    SHORT(true, false, 2),
    SHORT_ARRAY(true, true, -1),
    INTEGER(true, false, 4),
    INTEGER_ARRAY(true, true, -1),
    LONG(true, false, 8),
    LONG_ARRAY(true, true, -1),
    FLOAT(true, false, 4),
    FLOAT_ARRAY(true, true, -1),
    DOUBLE(true, false, 8),
    DOUBLE_ARRAY(true, true, -1),
    CHARACTER(true, false, 2),
    CHARACTER_ARRAY(true, true, -1),
    STRING(false, false, -1),
    STRING_ARRAY(false, true, -1);


    private final boolean primitive;
    private final boolean array;
    private final int fixedSize;

    DataType(boolean primitive, boolean array, int fixedSize) {
        this.primitive = primitive;
        this.array = array;
        this.fixedSize = fixedSize;
    }


    public final boolean isPrimitive() {
        return primitive;
    }

    public final boolean isArray() {
        return array;
    }

    public final int getSize() {
        return fixedSize;
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
