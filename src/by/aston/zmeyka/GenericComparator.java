package by.aston.zmeyka;

import java.util.Comparator;

/**
 * Класс GenericComparator представляет собой обобщенный компаратор, который реализует интерфейс Comparator.
 * Он позволяет сравнивать объекты, реализующие интерфейс Comparable, по их естественному порядку.
 *
 * @param <T> тип объектов, которые будут сравниваться
 */

public class GenericComparator<T extends Comparable<T>> implements Comparator<T> {
    /**
     * Сравнивает два объекта и возвращает результат сравнения.
     *
     * @param o1 первый объект для сравнения
     * @param o2 второй объект для сравнения
     * @return отрицательное число, если o1 меньше o2;
     *         положительное число, если o1 больше o2;
     *         ноль, если объекты равны
     */
    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }
}
