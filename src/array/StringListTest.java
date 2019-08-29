package array;

import java.util.ArrayList;

public class StringListTest {

    public static void main(String[] args) {

        StringList list1 = new StringList();
        StringList list2 = new StringList(2);
        StringList list3 = new StringList(0);

        list1.add("First String");
        String s = list1.get(0);
        int size = list1.size();

        System.out.println(s);  //First String
        System.out.println(size); //1

        list2.add("First");
        list2.add("Second");
        list2.add("Third");

        list3.add("First");
    }
}
