package iteration;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Iteration {

    public static void main(String[] args) {

//        AtomicInteger i= new AtomicInteger();
//        Stream.generate(i::getAndIncrement).forEach(System.out::println);

        Stream<Integer> infiniteStream = Stream.iterate(0, i -> i + 2);

    }
}
