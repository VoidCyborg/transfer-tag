package ru.voidcyborg.jttag.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.voidcyborg.jttag.Utils;

import java.nio.ByteBuffer;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void booleanToBytes() {
        boolean TRUE = true;
        boolean FALSE = false;

        byte[] actual = Utils.booleanToBytes(TRUE);
        byte[] expected = new byte[]{1};

        assertArrayEquals(expected, actual);

        actual = Utils.booleanToBytes(FALSE);
        expected = new byte[]{0};

        assertArrayEquals(expected, actual);
    }

    @Test
    void bytesToBoolean() {
        byte[] TRUE = new byte[]{1};
        byte[] FALSE = new byte[]{0};

        boolean actual = Utils.bytesToBoolean(TRUE);
        Assertions.assertTrue(actual);

        actual = Utils.bytesToBoolean(FALSE);
        Assertions.assertFalse(actual);


        //null
        try {
            Utils.bytesToBoolean(null);
            fail("My method didn't throw when I expected it to");
        } catch (Exception ignore) {
        }

        //size
        try {
            Utils.bytesToBoolean(new byte[]{3, 5});
            fail("My method didn't throw when I expected it to");
        } catch (Exception ignore) {
        }

        //byte value
        try {
            Utils.bytesToBoolean(new byte[]{3});
            fail("My method didn't throw when I expected it to");
        } catch (Exception ignore) {
        }
    }

    @Test
    void byteToBytes() {
        byte[] expected;
        byte[] actual;
        for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++) {
            actual = Utils.byteToBytes((byte) i);
            expected = new byte[]{(byte) i};

            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void bytesToByte() {
        byte[] bytes;

        byte expected;
        byte actual;
        for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++) {
            bytes = new byte[]{(byte) i};
            expected = (byte) i;
            actual = Utils.bytesToByte(bytes);

            assertEquals(expected, actual);
        }

        //null
        try {
            Utils.bytesToByte(null);
            fail("My method didn't throw when I expected it to");
        } catch (Exception ignore) {
        }

        //size
        try {
            Utils.bytesToByte(new byte[]{3, 5});
            fail("My method didn't throw when I expected it to");
        } catch (Exception ignore) {
        }
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

                assertEquals(expected, actual);
            }
        }

        //null
        try {
            Utils.bytesToShort(null);
            fail("My method didn't throw when I expected it to");
        } catch (Exception ignore) {
        }

        //size
        try {
            Utils.bytesToShort(new byte[]{3, 5, 3});
            fail("My method didn't throw when I expected it to");
        } catch (Exception ignore) {
        }
    }

    @Test
    void intToBytes() {

        ByteBuffer buffer = ByteBuffer.allocate(4);
        byte[] expected;
        byte[] actual;
        for (long l = Integer.MIN_VALUE; l <= Integer.MAX_VALUE; l += 5) {
            buffer.clear();
            buffer.putInt((int) l);
            expected = buffer.array();
            actual = Utils.intToBytes((int) l);

            assertArrayEquals(expected, actual);
        }
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

                        assertEquals(expected, actual);
                    }
                }
            }
        }

        //null
        try {
            Utils.bytesToInt(null);
            fail("My method didn't throw when I expected it to");
        } catch (Exception ignore) {
        }

        //size
        try {
            Utils.bytesToInt(new byte[]{3, 5, 3});
            fail("My method didn't throw when I expected it to");
        } catch (Exception ignore) {
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