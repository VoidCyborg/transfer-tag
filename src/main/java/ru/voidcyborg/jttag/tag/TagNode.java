package ru.voidcyborg.jttag.tag;

public abstract class TagNode<T> implements Tag {

    private final T value;

    protected TagNode(T value){
        if(value == null) throw new NullPointerException("Value can't be null.");
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public abstract byte[] toBytes();
}
