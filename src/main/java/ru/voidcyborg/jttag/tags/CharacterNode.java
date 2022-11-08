package ru.voidcyborg.jttag.tags;

import ru.voidcyborg.jttag.Utils;
import ru.voidcyborg.jttag.tag.DataType;
import ru.voidcyborg.jttag.tag.TagNode;

public class CharacterNode extends TagNode<Character> {
    private final char value;

    CharacterNode(char value) {
        this.value = value;
    }

    @Override
    public byte[] toBytes() {
        return Utils.uniteBytes(DataType.CHARACTER.toBytes(), Utils.charToBytes(value));
    }

    @Override
    public DataType getType() {
        return DataType.CHARACTER;
    }

    @Override
    public Character getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof CharacterNode node) {
            return this.value == node.value;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\"" + Utils.toJSON(value) + "\"";
    }
}
