package ru.voidcyborg.jttag.tag;

public abstract class TagNode<T> implements Tag {

    public abstract DataType getType();

    public abstract T getValue();

    public abstract byte[] toBytes();
}
