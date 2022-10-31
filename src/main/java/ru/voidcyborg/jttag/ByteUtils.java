package ru.voidcyborg.jttag;

public class ByteUtils {

    public static byte[] uniteBytes(byte[]... arrays) throws IllegalArgumentException {
        validateBytes(arrays);

        int size = 0;
        for (byte[] array : arrays) {
            size += array.length;
        }

        byte[] result = new byte[size];

        int index = 0;
        for (byte[] array : arrays) {
            for (byte b : array) {
                result[index] = b;
                index++;
            }
        }

        return result;
    }

    public static byte[] intToBytes(int value) {
        return new byte[]{
                (byte) (value >>> 24),
                (byte) (value >>> 16),
                (byte) (value >>> 8),
                (byte) value};
    }

    public static void validateBytes(byte[] bytes) throws IllegalArgumentException {
        if (bytes == null || bytes.length < 1) throw new IllegalArgumentException("Bytes cannot be null or empty.");
    }

    public static void validateBytes(byte[]... data) throws IllegalArgumentException {
        if (data == null) throw new IllegalArgumentException("Data array cannot be null.");
        if (data.length < 1) throw new IllegalArgumentException("Data array cannot be shorter than 8 bits.");
        for (byte[] bytes : data) {
            validateBytes(bytes);
        }
    }


}
