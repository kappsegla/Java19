package generics;

import ovn.v4.Rectangle;
import ovn.v4.Shape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem {

    public static void wildCard(List<? extends Shape> list){


    }

    public <T> T genericMethod(T inputType){
        T old = inputType;
        return old;
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("This is a String");
        String s = list.get(0);

        List<Rectangle> list2 = new ArrayList<>();

        wildCard(list2);

        Problem problem = new Problem();
        String s1 = "Test";
        String s2 = problem.genericMethod(s1);
        int i = problem.genericMethod(23);




        Storage<String> storage = new Storage<>();
        storage.add("Yihaa");
       

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Sten");
        map.put(2, "Påse");
        map.put(3, "Sax");
        String type = map.get(1);


    }
}
