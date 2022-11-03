package ru.voidcyborg.jttag.tag;

public interface Tag {
    byte[] toBytes();

    Tag fromBytes(byte[] bytes);
}
