package ru.voidcyborg.jttag;

import ru.voidcyborg.jttag.tag.TransferTag;

public class Main {


    public static void main(String[] args) {
        TransferTag tag = new TransferTag();
        tag.putString("lol", "data");
        tag.putString("g312", "fafafaf");
        tag.putString("43666", "da34444ta");


        TransferTag tagInside = tag.putTag("tag");
        tagInside.putString("name", "bebra");
        tagInside.putString("hi", "lol");

        System.out.println(tagInside.getString("name"));


        System.out.println(tagInside);
        System.out.println(tag);

        TransferTag get = tag.getTag("tag");
        System.out.println(get);


        TransferTag transferTag = new TransferTag();
        transferTag.putString("hi", "14221");
        transferTag.putString("hi2", null);
        transferTag.putInt("integer", 421565015);
        transferTag.putInt("integerKek", 521581091);
        transferTag.putStringArray("array", new String[]{"kek", null, "bebra", "allo"});
        transferTag.putByte("byte", (byte) 5);
        transferTag.putIntArray("intArray", new int[]{5151, 1257564, 124314, 2333, 228});
        transferTag.putIntArray("emptyArray", new int[0]);
        System.out.println(transferTag);


        TransferTag boltest = new TransferTag();
        boltest.putBoolean("test1", true);
        boltest.putBoolean("test2", false);
        boltest.putIntArray("intArray", new int[]{4214, 555, 11, 33, 777});
        boltest.putIntArray("intArray null", null);
        boltest.putByteArray("byteArray", new byte[]{44, 31, 127, -128});
        boltest.putByteArray("byteArray null", null);
        boltest.putBooleanArray("bolArray", null);
        boltest.putBooleanArray("bolArray2", new boolean[]{true, false, false});
        System.out.println(boltest);


        TransferTag shortTest = new TransferTag();
        shortTest.putShort("short", (short) 5215);
        System.out.println(shortTest);
        System.out.println(shortTest.getShort("short"));
        shortTest.putShortArray("array", null);
        shortTest.putShortArray("name", new short[]{2414, 666, 22220});
        shortTest.putShortArray("empty", new short[0]);
        System.out.println(shortTest);
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
        System.out.println(shortTest);

        TransferTag charTest = new TransferTag();
        charTest.putCharArray("charArray", new char[]{444, 0, 321, -0, 21355});
        charTest.putChar("char", (char) 68);
        System.out.println(charTest);


    }

}