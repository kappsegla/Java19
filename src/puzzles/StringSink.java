package puzzles;

import java.util.*;

//https://stackoverflow.com/questions/12462079/possible-heap-pollution-via-varargs-parameter

//Solution, use Collection<T> instead of T...

//abstract class Sink<T> {
//    abstract void add(T... elements);
//
//    void addUnlessNull(T... elements) {
//        for (T element :
//                elements) {
//            if (element != null)
//                add(element);
//        }
//    }
//}
//
//public class StringSink extends Sink<String> {
//    private final List<String> list = new ArrayList<>();
//
//    @Override
//    void add(String... elements) {
//        list.addAll(Arrays.asList(elements));
//    }
//
//    @Override
//    public String toString() {
//        return list.toString();
//    }
//
//    public static void main(String[] args) {
//        Sink<String> stringSink = new StringSink();
//        stringSink.addUnlessNull("null",null);
//        System.out.println(stringSink);
//    }
//}
abstract class Sink<T> {
    abstract void add(Collection<T> elements);

    void addUnlessNull(Collection<T> elements) {
        for (T element :
                elements) {
            if (element != null)
                add(Collections.singleton(element));
        }
    }
}

public class StringSink extends Sink<String> {
    private final List<String> list = new ArrayList<>();

    @Override
    void add(Collection<String> elements) {
        list.addAll(elements);
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        Sink<String> stringSink = new StringSink();
        stringSink.addUnlessNull(Arrays.asList("null",null));
        System.out.println(stringSink);
    }
}