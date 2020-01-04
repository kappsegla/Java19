package advancedstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");
        //long i =  stream.filter(x -> x.length() > 4).
        //stream.flatMap()

        //System.out.println(    stream.flatMap(s -> Stream.of(1,2,3)).count());
        List<String> data = Arrays.asList("functional", "super", "fish","flatfjället","fish","tank");
//        Queryable.of(data) // <=> data.stream().
//                .map(String::length)
//                .limit(2)
//                .forEach(System.out::println);
//
//                Queryable.of(data)
//                //.filter(w -> w.startsWith("f"))
//                .peek(System.out::println)
//                //.distinct()
//                .flatMap(s -> Queryable.of(List.of(s.split(""))))
//                        .peek(System.out::println)
//                //.map(String::length)
//                //.limit(2)
//                //.findLast().orElse("0"));
//                //.reduce("A", (s, s2) -> s));
//                .forEach(System.out::println);

        List<List<Integer>> nonFlat = List.of(List.of(1,2,3),List.of(4,5),List.of(6,7,8));
        Queryable.of(nonFlat)
                //.peek(System.out::println)
                .flatMap(Queryable::of)
                .forEach(System.out::println);


    }
}
