package ru.voidcyborg.jttag;

import ru.voidcyborg.jttag.tag.TransferTag;

import java.nio.ByteBuffer;

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
        boltest.putBooleanArray("bolArray2", new boolean[]{true,false,false});
        System.out.println(boltest);
    }

}