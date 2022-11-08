package ru.voidcyborg.jttag;

import ru.voidcyborg.jttag.tags.TagFactory;
import ru.voidcyborg.jttag.tags.TransferTag;

public class Main {


    public static void main(String[] args) {
        try {
            bebra();
            littleTest();
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