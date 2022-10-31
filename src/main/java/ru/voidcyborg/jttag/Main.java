package ru.voidcyborg.jttag;

import ru.voidcyborg.jttag.tag.TestTAG;

public class Main {
    public static void main(String[] args) {


        TestTAG tagInside = new TestTAG();
        tagInside.putString("name", "bebra");
        tagInside.putString("hi", "lol");

        System.out.println(tagInside);

        TestTAG tag = new TestTAG();
        tag.putString("lol", "data");
        tag.putString("g312", "fafafaf");
        tag.putString("43666", "da34444ta");
        tag.putTag("tag", tagInside);
        System.out.println(tag);

        TestTAG get = tag.getTag("tag");
        System.out.println(get);
    }
}