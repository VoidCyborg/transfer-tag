package ru.voidcyborg.jttag.tag;

public enum DataType {
    TAG,
    TAG_ARRAY,
    BOOLEAN,
    BOOLEAN_ARRAY,
    BYTE,
    BYTE_ARRAY,
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
    STRING,
    STRING_ARRAY;


    DataType() {

    }


    public final boolean isNullable(){

    }

    public final boolean getFixedSize(){

    }

    public final byte getCode() {
        return (byte) this.ordinal();
    }

    public final byte[] toBytes() {
        return new byte[]{getCode()};
    }

    public final DataType getType(byte code) throws IndexOutOfBoundsException {
        return DataType.values()[code];
    }
}
