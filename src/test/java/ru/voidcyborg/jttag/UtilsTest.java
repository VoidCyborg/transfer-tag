package ru.voidcyborg.jttag;

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
    void byteToBoolean() {
        byte TRUE = (byte) 1;
        byte FALSE = (byte) 0;

        boolean actual = Utils.byteToBoolean(TRUE);
        Assertions.assertTrue(actual);

        actual = Utils.byteToBoolean(FALSE);
        Assertions.assertFalse(actual);


        //byte value
        try {
            Utils.byteToBoolean((byte) 3);
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
        ByteBuffer buffer = ByteBuffer.allocate(8);
        byte[] expected;
        byte[] actual;
        for (long l = Long.MIN_VALUE; l < Long.MAX_VALUE - 6000_000_000L; l += 5000_000_000L) {
            buffer.clear();
            buffer.putLong(l);
            expected = buffer.array();
            actual = Utils.longToBytes(l);

            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void bytesToLong() {
        byte[] array = new byte[8];

        long expected;
        long actual;
        ByteBuffer buffer = ByteBuffer.allocate(8);
        for (long i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i += 20) {
            for (long j = Byte.MIN_VALUE; j <= Byte.MAX_VALUE; j += 20) {
                for (long k = Byte.MIN_VALUE; k <= Byte.MAX_VALUE; k += 20) {
                    for (long l = Byte.MIN_VALUE; l <= Byte.MAX_VALUE; l += 20) {
                        for (long m = Byte.MIN_VALUE; m <= Byte.MAX_VALUE; m += 20) {
                            for (long n = Byte.MIN_VALUE; n <= Byte.MAX_VALUE; n += 20) {
                                for (long o = Byte.MIN_VALUE; o <= Byte.MAX_VALUE; o += 20) {
                                    for (long p = Byte.MIN_VALUE; p <= Byte.MAX_VALUE; p += 20) {
                                        array[0] = (byte) i;
                                        array[1] = (byte) j;
                                        array[2] = (byte) k;
                                        array[3] = (byte) l;
                                        array[4] = (byte) m;
                                        array[5] = (byte) n;
                                        array[6] = (byte) o;
                                        array[7] = (byte) p;


                                        buffer.clear();
                                        buffer.put(array);
                                        buffer.rewind();
                                        expected = buffer.getLong();
                                        actual = Utils.bytesToLong(array);

                                        assertEquals(expected, actual);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        //null
        try {
            Utils.bytesToLong(null);
            fail("My method didn't throw when I expected it to");
        } catch (Exception ignore) {
        }

        //size
        try {
            Utils.bytesToLong(new byte[]{3, 5, 3});
            fail("My method didn't throw when I expected it to");
        } catch (Exception ignore) {
        }

    }

    @Test
    void floatToBytes() {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        byte[] expected;
        byte[] actual;
        for (double f = -10_000f; f < 10_000f; f += 0.00001f) {
            buffer.clear();
            buffer.putFloat((float) f);
            expected = buffer.array();
            actual = Utils.floatToBytes((float) f);

            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void bytesToFloat() {
        byte[] array = new byte[4];

        float expected;
        float actual;
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
                        expected = buffer.getFloat();
                        actual = Utils.bytesToFloat(array);

                        assertEquals(expected, actual);
                    }
                }
            }
        }

        //null
        try {
            Utils.bytesToFloat(null);
            fail("My method didn't throw when I expected it to");
        } catch (Exception ignore) {
        }

        //size
        try {
            Utils.bytesToFloat(new byte[]{3, 5, 3});
            fail("My method didn't throw when I expected it to");
        } catch (Exception ignore) {
        }
    }

    @Test
    void doubleToBytes() {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        byte[] expected;
        byte[] actual;
        for (double d = -10_000f; d < 10_000f; d += 0.00001) {
            buffer.clear();
            buffer.putDouble(d);
            expected = buffer.array();
            actual = Utils.doubleToBytes(d);

            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void bytesToDouble() {
        byte[] array = new byte[8];

        double expected;
        double actual;
        ByteBuffer buffer = ByteBuffer.allocate(8);
        for (long i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i += 20) {
            for (long j = Byte.MIN_VALUE; j <= Byte.MAX_VALUE; j += 20) {
                for (long k = Byte.MIN_VALUE; k <= Byte.MAX_VALUE; k += 20) {
                    for (long l = Byte.MIN_VALUE; l <= Byte.MAX_VALUE; l += 20) {
                        for (long m = Byte.MIN_VALUE; m <= Byte.MAX_VALUE; m += 20) {
                            for (long n = Byte.MIN_VALUE; n <= Byte.MAX_VALUE; n += 20) {
                                for (long o = Byte.MIN_VALUE; o <= Byte.MAX_VALUE; o += 20) {
                                    for (long p = Byte.MIN_VALUE; p <= Byte.MAX_VALUE; p += 20) {
                                        array[0] = (byte) i;
                                        array[1] = (byte) j;
                                        array[2] = (byte) k;
                                        array[3] = (byte) l;
                                        array[4] = (byte) m;
                                        array[5] = (byte) n;
                                        array[6] = (byte) o;
                                        array[7] = (byte) p;


                                        buffer.clear();
                                        buffer.put(array);
                                        buffer.rewind();
                                        expected = buffer.getDouble();
                                        actual = Utils.bytesToDouble(array);

                                        assertEquals(expected, actual);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        //null
        try {
            Utils.bytesToDouble(null);
            fail("My method didn't throw when I expected it to");
        } catch (Exception ignore) {
        }

        //size
        try {
            Utils.bytesToDouble(new byte[]{3, 5, 3});
            fail("My method didn't throw when I expected it to");
        } catch (Exception ignore) {
        }
    }

    @Test
    void charToBytes() {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        byte[] expected;
        byte[] actual;
        for (int i = Character.MIN_VALUE; i <= Character.MAX_VALUE; i++) {
            buffer.clear();
            buffer.putChar((char) i);
            expected = buffer.array();
            actual = Utils.charToBytes((char) i);

            assertArrayEquals(expected, actual);
        }
    }

    @Test
    void bytesToChar() {
        byte[] array = new byte[2];

        char expected;
        char actual;
        ByteBuffer buffer = ByteBuffer.allocate(2);
        for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++) {
            for (int j = Byte.MIN_VALUE; j <= Byte.MAX_VALUE; j++) {
                array[0] = (byte) i;
                array[1] = (byte) j;
                buffer.clear();
                buffer.put(array);
                buffer.rewind();
                expected = buffer.getChar();
                actual = Utils.bytesToChar(array);

                assertEquals(expected, actual);
            }
        }

        //null
        try {
            Utils.bytesToChar(null);
            fail("My method didn't throw when I expected it to");
        } catch (Exception ignore) {
        }

        //size
        try {
            Utils.bytesToChar(new byte[]{3, 5, 3});
            fail("My method didn't throw when I expected it to");
        } catch (Exception ignore) {
        }
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