package ru.voidcyborg.jttag;

import ru.voidcyborg.jttag.tag.TransferTag;

public class Main {
    public static void main(String[] args) {


        TransferTag tagInside = new TransferTag();
        tagInside.putString("name", "bebra");
        tagInside.putString("hi", "lol");

        System.out.println(tagInside);

        TransferTag tag = new TransferTag();
        tag.putString("lol", "data");
        tag.putString("g312", "fafafaf");
        tag.putString("43666", "da34444ta");
        tag.putTag("tag", tagInside);
        System.out.println(tag);

        TransferTag get = tag.getTag("tag");
        System.out.println(get);
    }
}