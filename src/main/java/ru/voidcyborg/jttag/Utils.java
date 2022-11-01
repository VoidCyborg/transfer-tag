package ru.voidcyborg.jttag;

public class Utils {

    private static final String reservedJSON = "\b\f\n\r\t\"\\/";
    private static final String[] replacementJSON = new String[]{"\\b", "\\f", "\\n", "\\r", "\\t", "\\\"", "\\\\", "\\/"};


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

    public static int bytesToInt(byte[] bytes) throws IllegalArgumentException {
        validateBytes(bytes);
        if (bytes.length != 4) throw new IllegalArgumentException("Int size should be 4, but size is " + bytes.length);

        int value = 0;
        for (byte b : bytes) {
            value = (value << 8) + (b & 0xFF);
        }
        return value;
    }

    public static byte[] byteToBytes(byte value) {
        return new byte[]{value};
    }

    public static byte bytesToByte(byte[] bytes) {
        validateBytes(bytes);
        if (bytes.length != 1) throw new IllegalArgumentException("Byte size should be 1, but size is " + bytes.length);

        return bytes[0];
    }


    public static String toJSON(String s) {
        if (s == null) return null;

        StringBuilder builder = new StringBuilder();

        int index;
        for (char c : s.toCharArray()) {
            index = reservedJSON.indexOf(c);
            if (index != -1) builder.append(replacementJSON[index]);
            else builder.append(c);
        }

        return builder.toString();
    }

    public static void validateBytes(byte[] bytes) throws IllegalArgumentException {
        if (bytes == null) throw new IllegalArgumentException("Bytes cannot be null.");
    }

    public static void validateBytes(byte[]... data) throws IllegalArgumentException {
        if (data == null) throw new IllegalArgumentException("Data array cannot be null.");
        for (byte[] bytes : data) {
            validateBytes(bytes);
        }
    }


}
