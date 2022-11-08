package ru.voidcyborg.jttag;

import ru.voidcyborg.jttag.tag.TagFactory;
import ru.voidcyborg.jttag.tag.DataType;
import ru.voidcyborg.jttag.tag.Tag;
import ru.voidcyborg.jttag.tag.TransferTag;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Main {


    public static void main(String[] args) {
        try {
            littleTest();


            TransferTag tag = new TransferTag();
            tag.putString("lol", "data");
            tag.putString("g312", "fafafaf");
            tag.putString("43666", "da34444ta");


            TransferTag tagInside = tag.putTag("tag");
            tagInside.putString("name", "bebra");
            tagInside.putString("hi", "lol");


            TransferTag boltest = tag.putTag("boolTest");
            boltest.putBoolean("test1", true);
            boltest.putBoolean("test2", false);
            boltest.putIntArray("intArray", new int[]{4214, 555, 11, 33, 777});
            boltest.putIntArray("intArray null", null);
            boltest.putByteArray("byteArray", new byte[]{44, 31, 127, -128});
            boltest.putByteArray("byteArray null", null);
            boltest.putBooleanArray("bolArray", null);
            boltest.putBooleanArray("bolArray2", new boolean[]{true, false, false});


            TransferTag shortTest = tag.putTag("ShortTest");
            shortTest.putShort("short", (short) 5215);
            shortTest.putShortArray("array", null);
            shortTest.putShortArray("name", new short[]{2414, 666, 22220});
            shortTest.putShortArray("empty", new short[0]);

            TransferTag tag2 = shortTest.putTag("tag2");
            tag2.putFloat("float", 421412.32541f);
            tag2.putFloat("ffff", -421412.566666f);
            tag2.putShortArray("short2", new short[]{2155, 666, 1111});

            TransferTag tag3 = tag2.putTag("tag3");
            tag3.putFloatArray("array", new float[]{-42141.55f, 115215.5512f, 0.00001f});
            tag3.putFloatArray("empty", new float[0]);
            tag3.putFloatArray("null", null);
            tag3.putDouble("double", 2142142198412.312314444444444);
            tag3.putDoubleArray("double_array", new double[]{2142142198412.312314444444444, 421481184.4214144, 1616215421.421414141});
            tag3.putDoubleArray("double_empty", new double[0]);
            tag3.putDoubleArray("double_null", null);
            tag3.putChar("char", '\n');
            tag3.putChar("char2", '@');

            TransferTag charTest = tag.putTag("charTest");
            charTest.putCharArray("charArray", new char[]{444, 0, 321, -0, 21355});
            charTest.putChar("char", (char) 68);

            System.out.println(tag);
            byte[] bytes = tag.toBytes();
            System.out.println(bytes.length);

            TransferTag reconstructed = TagFactory.transferTag(bytes);

            System.out.println(tag.equals(reconstructed));
            System.out.println(reconstructed);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void littleTest() {
        TransferTag tag = new TransferTag();
        tag.putString("chatMessage", "HelloWorld!!!");
        byte[] bytes = tag.toBytes();
        System.out.println("SIZE:" + bytes.length);

        TransferTag reconstruct = TagFactory.transferTag(bytes);
        System.out.println(reconstruct);
    }


    private static void bebra() {
        final long n = 6L;
        long x = pow(36L, 7L) + pow(6L, 19L) - 18L;
        System.out.println(x);

        long left;

        StringBuilder builder = new StringBuilder();
        while (x > 0) {
            left = x % n;
            x = x / n;
            builder.append(left);
        }

        builder.reverse();

        System.out.println("DIGREL:" + builder.toString());
    }

    private static long pow(long a, long b) {
        long result = 1;
        for (long l = 0; l < b; l++) {
            result *= a;
        }
        return result;
    }

}