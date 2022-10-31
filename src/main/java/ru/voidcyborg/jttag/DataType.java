package ru.voidcyborg.jttag;

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



    public byte getCode() {
        return (byte) this.ordinal();
    }

    public byte[] toBytes() {
        return new byte[]{getCode()};
    }

    public DataType getType(byte code) throws IndexOutOfBoundsException {
        return DataType.values()[code];
    }
}
