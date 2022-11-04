package ru.voidcyborg.jttag;

public class Utils {

    private static final String reservedJSON = "\b\f\n\r\t\"\\/";
    private static final String[] replacementJSON = new String[]{"\\b", "\\f", "\\n", "\\r", "\\t", "\\\"", "\\\\", "\\/"};


    public static byte[] booleanToBytes(boolean value) {
        return value ? new byte[]{1} : new byte[]{0};
    }

    public static boolean bytesToBoolean(byte[] bytes) throws IllegalArgumentException {
        validateBytes(bytes);
        if (bytes.length != 1)
            throw new IllegalArgumentException("Bytes size should be 1, but size is " + bytes.length);
        if (bytes[0] != 0 && bytes[0] != 1)
            throw new IllegalArgumentException("Boolean value in bytes can be only 1 or 0, not " + bytes[0]);

        return bytes[0] == 1;
    }

    public static byte[] byteToBytes(byte value) {
        return new byte[]{value};
    }

    public static byte bytesToByte(byte[] bytes) throws IllegalArgumentException {
        validateBytes(bytes);
        if (bytes.length != 1) throw new IllegalArgumentException("Byte size should be 1, but size is " + bytes.length);

        return bytes[0];
    }

    public static byte[] shortToBytes(short value) {
        return new byte[]{
                (byte) (value >> 8),
                (byte) value};
    }

    public static short bytesToShort(byte[] bytes) throws IllegalArgumentException {
        validateBytes(bytes);
        if (bytes.length != 2)
            throw new IllegalArgumentException("Bytes size should be 2, but size is " + bytes.length);

        return (short) (((bytes[0] & 0xFF) << 8) |
                ((bytes[1] & 0xFF)));
    }

    public static byte[] intToBytes(int value) {
        return new byte[]{
                (byte) (value >> 24),
                (byte) (value >> 16),
                (byte) (value >> 8),
                (byte) value};
    }

    public static int bytesToInt(byte[] bytes) throws IllegalArgumentException {
        validateBytes(bytes);
        if (bytes.length != 4)
            throw new IllegalArgumentException("Bytes size should be 4, but size is " + bytes.length);

        return ((bytes[0] & 0xFF) << 24) |
                ((bytes[1] & 0xFF) << 16) |
                ((bytes[2] & 0xFF) << 8) |
                ((bytes[3] & 0xFF));
    }

    public static byte[] longToBytes(long value) {
        return new byte[]{
                (byte) (value >> 56),
                (byte) (value >> 48),
                (byte) (value >> 40),
                (byte) (value >> 32),
                (byte) (value >> 24),
                (byte) (value >> 16),
                (byte) (value >> 8),
                (byte) value};
    }

    public static long bytesToLong(byte[] bytes) throws IllegalArgumentException {
        validateBytes(bytes);
        if (bytes.length != 8)
            throw new IllegalArgumentException("Bytes size should be 8, but size is " + bytes.length);

        long result = 0;
        result |= ((long) bytes[0] & 0xFF);
        result <<= 8;
        result |= ((long) bytes[1] & 0xFF);
        result <<= 8;
        result |= ((long) bytes[2] & 0xFF);
        result <<= 8;
        result |= ((long) bytes[3] & 0xFF);
        result <<= 8;
        result |= ((long) bytes[4] & 0xFF);
        result <<= 8;
        result |= ((long) bytes[5] & 0xFF);
        result <<= 8;
        result |= ((long) bytes[6] & 0xFF);
        result <<= 8;
        result |= ((long) bytes[7] & 0xFF);
        result <<= 8;

        return result;
    }

    public static byte[] floatToBytes(float value) {
        int integer = Float.floatToIntBits(value);
        return new byte[]{
                (byte) (integer >> 24),
                (byte) (integer >> 16),
                (byte) (integer >> 8),
                (byte) integer};
    }

    public static float bytesToFloat(byte[] bytes) throws IllegalArgumentException {
        validateBytes(bytes);
        if (bytes.length != 4)
            throw new IllegalArgumentException("Bytes size should be 4, but size is " + bytes.length);


        int integer = ((bytes[0] & 0xFF) << 24) |
                ((bytes[1] & 0xFF) << 16) |
                ((bytes[2] & 0xFF) << 8) |
                ((bytes[3] & 0xFF));

        return Float.intBitsToFloat(integer);
    }

    public static byte[] doubleToBytes(double value) {
        long longValue = Double.doubleToLongBits(value);
        return new byte[]{
                (byte) (longValue >> 56),
                (byte) (longValue >> 48),
                (byte) (longValue >> 40),
                (byte) (longValue >> 32),
                (byte) (longValue >> 24),
                (byte) (longValue >> 16),
                (byte) (longValue >> 8),
                (byte) longValue};
    }

    public static double bytesToDouble(byte[] bytes) throws IllegalArgumentException {
        validateBytes(bytes);
        if (bytes.length != 8)
            throw new IllegalArgumentException("Bytes size should be 8, but size is " + bytes.length);


        long longValue = bytesToLong(bytes);

        return Double.longBitsToDouble(longValue);
    }

    public static byte[] charToBytes(char value) {
        return new byte[]{
                (byte) (value >> 8),
                (byte) value};
    }

    public static char bytesToChar(byte[] bytes) throws IllegalArgumentException {
        validateBytes(bytes);
        if (bytes.length != 2)
            throw new IllegalArgumentException("Bytes size should be 2, but size is " + bytes.length);

        return (char) (((bytes[0] & 0xFF) << 8) |
                ((bytes[1] & 0xFF)));
    }

    //JSON + bytes
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

    public static String toJSON(char c) {
        StringBuilder builder = new StringBuilder();

        int index = reservedJSON.indexOf(c);
        if (index != -1) builder.append(replacementJSON[index]);
        else builder.append(c);

        return builder.toString();
    }


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
