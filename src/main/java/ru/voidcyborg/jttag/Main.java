package ru.voidcyborg.jttag;

import ru.voidcyborg.jttag.tag.TransferTag;

import java.util.Arrays;

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
        transferTag.putStringArray("array", new String[]{"kek", null, "bebra", "allo"});
        System.out.println(transferTag);
    }
}