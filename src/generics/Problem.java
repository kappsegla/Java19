package generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("This is a String");
        String s = list.get(0);

        Storage<String> storage = new Storage<>();
        storage.add("Yihaa");
        String s2 = storage.get();

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Sten");
        map.put(2, "Påse");
        map.put(3, "Sax");
        String type = map.get(1);


    }
}
