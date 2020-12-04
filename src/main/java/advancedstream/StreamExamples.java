package advancedstream;

import java.sql.ClientInfoStatus;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.*;

public class StreamExamples {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");

        //   stream.peek(System.out::println).skip(1).forEach(System.out::println);

        //long i =  stream.filter(x -> x.length() > 4).
        //stream.flatMap()
        //System.out.println(    stream.flatMap(s -> Stream.of(1,2,3)).count());
        List<String> data = Arrays.asList("functional", "super", "fish", "flatfjället", "fish", "tank");


        List<List<Integer>> nonFlat = List.of(List.of(1, 2, 3), List.of(4, 5), List.of(6, 7, 8));
        Set<Integer> set = Set.of(9, 5, 3, 1, 7, 2, 4, 8);
//        Set<Integer> set = new TreeSet<>(List.of(9, 5, 3, 1, 7, 2, 4, 8));

        nonFlat.stream()
                //.peek(System.out::println)
                .flatMap(list -> list.stream())
                //.peek(System.out::println)
                //.limit(2)
                .forEach(System.out::println);

//        System.out.println(
//        System.out.println(Queryable.of(set)
//                .sorted(Comparator.naturalOrder())
//                .map(p-> p * Math.random())
//                .sorted(Comparator.reverseOrder())
//                .peek(System.out::println)
//                .allMatch(p-> p < 10));

        var resultMap = data.stream().collect(teeing(
                filtering(s -> s.startsWith("f"), toList()),
                filtering(not(s -> s.startsWith("f")), toList()),
                (f, notf) -> {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("f", f);
                    map.put("other", notf);
                    return map;
                }
        ));


        IntStream.iterate(1, n -> n + 1)
                .skip(2)
                .limit(10)
                .filter(p -> p < 10)
                .forEach(System.out::println);


        Queryable.iterate(1, i -> i + 1)
                .skip(2)
                .map(i -> i % 2)
                .takeWhile(p -> p < 10)
                .forEach(System.out::println);
    }
}
