package iteration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Iteration {


    private final List<String> strings = new ArrayList<>() {
    };

    List<? extends String> getList() {
        return strings;
    }

    public static void main(String[] args) {

        //AtomicInteger i= new AtomicInteger();
        // Stream.generate(i::getAndIncrement).forEach(System.out::println);

        //Stream<Integer> infiniteStream = Stream.iterate(0, i -> i + 2);

        var immutableObject = new Iteration();
        immutableObject.strings.add("Martin");
        immutableObject.strings.add("Kalle");

        var list = immutableObject.getList();

        //Can't add because of the ? extends String
        //list.add("Anna");
        var name = list.get(0);
    }
}
