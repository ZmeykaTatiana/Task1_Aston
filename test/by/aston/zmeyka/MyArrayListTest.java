package by.aston.zmeyka;

//import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class MyArrayListTest {
   private MyArrayList<String>list ;


    @Before
    public void setup(){
        list=new MyArrayList<>();
        list.addElement("Hello");
        list.addElement("Bye");
        list.addElement("Ok");
        list.addElement("vrum-vrum");

    }

    @Test
    public void testAddElement() {
        String str="RAMMSTEIN";
        list.addElement(str);
        assertEquals(5,list.size());
        assertEquals("RAMMSTEIN",list.getElement(4));

    }
    @Test
    public void testAddElementByIndex() {
        // Проверяем исходное состояние массива
        assertArrayEquals(new String[]{"Hello","Bye","Ok","vrum-vrum"}, list.getArray());

        // Добавляем элемент по индексу 1
        list.addElementByIndex(1, "IndiiskiyChai");

        // Проверяем, что элемент успешно добавлен
       assertArrayEquals(new String[]{"Hello","IndiiskiyChai","Bye","Ok","vrum-vrum"}, list.getArray());

        // Проверяем добавление элемента в начало массива
        list.addElementByIndex(0, "start");
        assertArrayEquals(new String[]{"start", "Hello","IndiiskiyChai","Bye","Ok","vrum-vrum"}, list.getArray());

    }


    @Test
    public void testGetElement() {
        assertEquals("Ok",list.getElement(2));
    }
    @Test
    public void testGetElementOutOfBounds() {
        // Проверка исключения при выходе за пределы массива
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            list.getElement(10);
        });
    }

    @Test
    public void testDeleteElementByIndex() {
        // Удаление элемента по индексу
        list.deleteElementByIndex(2);

        // Проверка, что элемент успешно удален
          assertEquals(3, list.size());

        // Проверка, что элементы после удаления сдвинулись на одну позицию влево
        assertEquals("Hello", list.getElement(0));
        assertEquals("Bye", list.getElement(1));
        assertEquals("vrum-vrum", list.getElement(2));

    }

    @Test
    public void testDeleteElement() {
        boolean result = list.deleteElement("Bye");

        // Проверка, что элемент успешно удален
        assertTrue(result);
        assertEquals(3, list.size());

        // Проверка, что элементы после удаления сдвинулись
        assertEquals("Hello", list.getElement(0));
        assertEquals("Ok", list.getElement(1));
        assertEquals("vrum-vrum", list.getElement(2));

    }

    @Test
    public void testDeleteNonexistentElement() {
        // Попытка удаления несуществующего элемента
        boolean result = list.deleteElement("AKUNA");

        // Проверка, что удаление несуществующего элемента возвращает false
        assertFalse(result);


        // Проверка, что массив остался неизменным
        assertEquals(4, list.size());
        assertEquals("Hello", list.getElement(0));
       assertEquals("Bye", list.getElement(1));
        assertEquals("Ok", list.getElement(2));
        assertEquals("vrum-vrum", list.getElement(3));

    }


    @Test
    public void testClear() {
        list.addElement("Element 1");
        list.addElement("Element 2");

        list.clear();
        assertEquals(0, list.size());
    }



    @Test
    public void testSet() {
        // Установка нового значения элемента по индексу
        list.set(1, "BUGAGASCHENKI");

        // Проверка, что элемент успешно изменен
       assertEquals("BUGAGASCHENKI", list.getElement(1));

        // Проверка, что остальные элементы остались неизменными
       assertEquals("Hello", list.getElement(0));
        assertEquals("Ok", list.getElement(2));
        assertEquals("vrum-vrum", list.getElement(3));
    }


    @Test
    public void testSize() {
        assertEquals(4,list.size());

    }

    @Test
    public  void testquicSortic(){
        // Вызов метода quicSortic для сортировки массива
        list.quicSortic(list, 0, list.size() - 1);

        // Проверка, что массив был отсортирован по возрастанию
       assertArrayEquals(new String[]{"Bye","Hello","Ok","vrum-vrum"}, list.getArray());

    }


    @After
    public void clearDown() {
        list.clear();
    }
}