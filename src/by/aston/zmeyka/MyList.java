package by.aston.zmeyka;
/**
 * Интерфейс MyList представляет собой список элементов.
 *
 * @param <T> тип элементов в списке
 */

public interface MyList <T> extends Iterable<T>
{
    boolean addElement(T t);
    boolean addElementByIndex(int index,T t);
    T getElement(int index);
    boolean deleteElementByIndex (int index);
    boolean deleteElement(T t);
    void clear();
    void set (int index, T t);
    int size();
}
