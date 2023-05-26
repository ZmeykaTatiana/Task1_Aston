package by.aston.zmeyka;

import java.util.List;

public class Main {
    public static void main(String[] args) {
       MyArrayList<Integer>list=new MyArrayList<>();
       list.addElement(5);
        list.addElement(15);
        list.addElement(10);
        list.addElement(3);
        System.out.println(list);
        list.addElementByIndex(1,111);
        System.out.println(list);
        list.addElementByIndex(15, 000);
        System.out.println(list);




    }
}
