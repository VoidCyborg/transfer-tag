package ru.voidcyborg.jttag.tag;

public abstract class TagNode<T> implements Tag {

    public abstract DataType getType();

    public abstract T getValue();

    @Override
    public abstract byte[] toBytes();

    @Override
    public abstract TagNode<T> fromBytes(byte[] bytes);
}
