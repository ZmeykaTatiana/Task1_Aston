package by.aston.zmeyka;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * MyIterator - обобщенная реализация итератора для перебора элементов массива.
 *
 * @param <T> тип элементов в массиве
 */
public class MyIterator <T> implements Iterator<T> {
    private T[]array;
    private int index=0;

    /**
     * Конструктор объекта MyIterator с указанным массивом.
     *
     * @param array массив, который будет перебираться
     */
    public MyIterator(T[] array) {
        this.array = array;
    }
    /**
     * Проверяет наличие следующего элемента для перебора.
     *
     * @return {@code true}, если есть следующий элемент, {@code false} в противном случае
     */
    @Override
    public boolean hasNext() {
        return index<array.length;
    }
    /**
     * Возвращает следующий элемент перебора.
     *
     * @return следующий элемент
     */
    @Override
    public T next() {
        return array[index++];
    }
}
