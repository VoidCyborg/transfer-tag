package ru.voidcyborg.jttag.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.voidcyborg.jttag.Utils;

import java.nio.ByteBuffer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class UtilsTest {

    @Test
    void booleanToBytes() {
        boolean TRUE = true;
        boolean FALSE = false;

        byte[] bytes = Utils.booleanToBytes(TRUE);
        boolean actual = Utils.bytesToBoolean(bytes);
        Assertions.assertEquals(TRUE, actual);

        bytes = Utils.booleanToBytes(FALSE);
        actual = Utils.bytesToBoolean(bytes);
        Assertions.assertEquals(FALSE, actual);
    }

    @Test
    void bytesToBoolean() {
        byte[] TRUE = new byte[]{1};
        byte[] FALSE = new byte[]{0};

        boolean actual = Utils.bytesToBoolean(TRUE);
        Assertions.assertTrue(actual);

        actual = Utils.bytesToBoolean(FALSE);
        Assertions.assertFalse(actual);
    }

    @Test
    void byteToBytes() {
    }

    @Test
    void bytesToByte() {
    }

    @Test
    void shortToBytes() {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        byte[] expected;
        byte[] actual;
        for (int i = Short.MIN_VALUE; i <= Short.MAX_VALUE; i++) {
            buffer.clear();
            buffer.putShort((short) i);
            expected = buffer.array();
            actual = Utils.shortToBytes((short) i);

            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void bytesToShort() {
        byte[] array = new byte[2];

        short expected;
        short actual;
        ByteBuffer buffer = ByteBuffer.allocate(2);
        for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++) {
            for (int j = Byte.MIN_VALUE; j <= Byte.MAX_VALUE; j++) {
                array[0] = (byte) i;
                array[1] = (byte) j;
                buffer.clear();
                buffer.put(array);
                buffer.rewind();
                expected = buffer.getShort();
                actual = Utils.bytesToShort(array);

                Assertions.assertEquals(expected, actual);
            }
        }
    }

    @Test
    void intToBytes() {
    }

    @Test
    void bytesToInt() {
        byte[] array = new byte[4];

        int expected;
        int actual;
        ByteBuffer buffer = ByteBuffer.allocate(4);
        for (long i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i += 2) {
            for (long j = Byte.MIN_VALUE; j <= Byte.MAX_VALUE; j += 2) {
                for (long k = Byte.MIN_VALUE; k <= Byte.MAX_VALUE; k += 2) {
                    for (long l = Byte.MIN_VALUE; l <= Byte.MAX_VALUE; l += 2) {
                        array[0] = (byte) i;
                        array[1] = (byte) j;
                        array[2] = (byte) k;
                        array[3] = (byte) l;


                        buffer.clear();
                        buffer.put(array);
                        buffer.rewind();
                        expected = buffer.getInt();
                        actual = Utils.bytesToInt(array);

                        Assertions.assertEquals(expected, actual);
                    }
                }
            }
        }

    }

    @Test
    void longToBytes() {
    }

    @Test
    void bytesToLong() {
    }

    @Test
    void floatToBytes() {
    }

    @Test
    void bytesToFloat() {
    }

    @Test
    void doubleToBytes() {
    }

    @Test
    void bytesToDouble() {
    }

    @Test
    void charToBytes() {
    }

    @Test
    void bytesToChar() {
    }

    @Test
    void toJSON() {
    }

    @Test
    void testToJSON() {
    }

    @Test
    void uniteBytes() {
    }

    @Test
    void validateBytes() {
    }

    @Test
    void testValidateBytes() {
    }
}