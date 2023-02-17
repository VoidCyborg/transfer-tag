package ru.voidcyborg.jttag.tag;

public interface Tag {
    /**
     * Должен включать тип данных, если данные с переменной длинной их размер, и сами данные.
     * <p>byte[1] type + byte[fixed] data</p>
     * <p>byte[1] type + byte[4] size + byte[size] data</p>
     */
    byte[] toBytes();

    /**
     * Количество табов которые необходимо добавить, для красивой вложенности.
     */
    String toJson(long tabs);

}
