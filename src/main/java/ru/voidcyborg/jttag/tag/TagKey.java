package ru.voidcyborg.jttag.tag;

import ru.voidcyborg.jttag.tags.StringNode;

public final class TagKey {
    private final StringNode key;
    private final DataType type;

    public TagKey(StringNode key, DataType type) {
        if (key == null || type == null) throw new NullPointerException("Key can't be null");
        this.key = key;
        this.type = type;
    }

    public StringNode getKey() {
        return key;
    }

    public DataType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (o instanceof TagKey key) {
            if (key.type != this.type) return false;
            if (!key.key.equals(this.key)) return false;
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return key.hashCode() + type.getCode();
    }

    @Override
    public String toString() {
        return key.toString();
    }
}
