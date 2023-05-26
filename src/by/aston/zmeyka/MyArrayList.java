package by.aston.zmeyka;

import java.util.*;
/**
 *Это общая реализация интерфейса MyList с использованием массива.
 *
 * @param <T> тип элементов, хранящихся в списке
 */
public class MyArrayList <T> implements MyList<T> {
    private T[] array;
    /**
     * Конструктор создает новый экземпляр MyArrayList с пустым начальным массивом.
     */
    public MyArrayList() {
        this.array = (T[]) new Object[0]; // касим до типа Т
    }


    /**
     * Добавляем элемент в  список (в конец).
     *
     * @param t добавляемый элемент
     * @return true, если элемент успешно добавлен, false в противном случае
     */

    @Override
    public boolean addElement(T t) {
        // Создаем пустой массив размером на один больше, чем исходный,так как добавляем один элемент
            T[] temp = (T[]) new Object[array.length + 1];
            int i = 0;
            for (; i < array.length; i++) {
                temp[i] = array[i];

            }
            temp[i] = t;
            array = temp;

            return true;

    }

    /**
     * Добавляем элемент по указанному индексу в список.
     *
     * @param index индекс, по которому должен быть добавлен элемент
     * @param t     добавляемый элемент
     * @return true, если элемент успешно добавлен, false в противном случае
     */

    @Override
    public boolean addElementByIndex(int index, T t) {
        if (index < array.length) {
            T[] temp = (T[]) new Object[array.length + 1];


            for (int i = 0, j = 0; i < array.length; i++, j++) {
                if (i == index) {
                    temp[j] = t;
                    j++;
                }
                temp[j] = array[i];
            }
            array = temp;
            return true;


        }
        return false;
    }


    /**
     * Получаем элемент по индексу в списке.
     *
     * @param index индекс получаемого элемента
     * @return элемент по указанному индексу
     */

    @Override
    public T getElement(int index) {
        return array[index];
    }

    /**
     * Удаляем элемент по индексу из списка.
     *
     * @param index индекс удаляемого элемента
     */


    @Override
    public boolean deleteElementByIndex(int index) {
        // Создаем пустой массив размером на один меньше чем исходный,так как удаляем один элемент
        T[] temp = (T[]) new Object[array.length - 1];
        if (index < temp.length) {
            for (int i = 0; i < index; i++) {
                temp[i] = array[i];

            }

            for (int i = index; i < array.length - 1; i++) {
                temp[i] = array[i + 1];
            }
            array = temp;
            return true;
        }
        return false;
    }

    /**
     * Удаляем первый указанный в списке  элемент из списка.
     *
     * @param t удаляемый элемент
     * @return true, если элемент успешно удален, false в противном случае
     */

    @Override
    public boolean deleteElement(T t) {
        List<T> list = Arrays.asList(array);

        if (list.contains(t)) {
            T[] temp = (T[]) new Object[array.length - 1];
            int index = 0;

            for (int i = 0; i < array.length; i++) {

                if (array[i] == t) {
                    index = i;
                }
            }

            for (int i = 0; i < index; i++) {
                temp[i] = array[i];

            }

            for (int i = index; i < array.length - 1; i++) {
                temp[i] = array[i + 1];
            }
            array = temp;
            return true;
        }
        return false;
    }


    public T[] getArray() {
        return array;
    }


    /**
     * Удаляем все элементы из списка.
     */
    @Override
    public void clear() {
        T []temp = (T[])new Object[0];
        array=temp;
    }
    /**
     * Заменяем элемент по  индексу на другой указанный элемент.
     *
     * @param index индекс элемента, который меняем
     * @param t     новый элемент
     */

    @Override
    public void set(int index, T t) {
         array[index]=t;
    }

    /**
     * Возвращает количество элементов в списке.
     *
     * @return количество элементов в списке
     */
    @Override
    public int size() {
        return array.length;
    }


    /**
     * Сортируем элементы в списке, используя алгоритм быстрой сортировки
     *
     * @param myArrayList лист, который необходимо отсортировать
     * @param a           начальный индекс списка для сортировки
     * @param b           конечный индекс списка для сортировки
     */
    public  void quicSortic(MyArrayList<T>myArrayList,int a, int b){
         T[] array= myArrayList.getArray();
        GenericComparator comparator=new GenericComparator();

        if(array.length==0||a>=b){
            return;
        }

        T marker=array[a];
        int i=a;
        int j=b;
        while (i<=j){
            while(comparator.compare((Comparable) array[i], (Comparable) marker)<0)i++;
            while(comparator.compare((Comparable) array[j], (Comparable) marker)>0)j--;
            if(i<=j){
                T temp=  array[i];
                array[i]=array[j];
                array[j]=temp;
                i++;
                j--;
            }
        }

        if(a<j) quicSortic(myArrayList, a,j);
        if(b>i) quicSortic(myArrayList,i,b);}


    @Override
    public String toString() {
        return Arrays.toString(array) ;
    }


    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(array);
    }
}

