package advancedstream;

import java.sql.ClientInfoStatus;
import java.util.*;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");

        //   stream.peek(System.out::println).skip(1).forEach(System.out::println);

        //long i =  stream.filter(x -> x.length() > 4).
        //stream.flatMap()
        //System.out.println(    stream.flatMap(s -> Stream.of(1,2,3)).count());
        List<String> data = Arrays.asList("functional", "super", "fish", "flatfjället", "fish", "tank");


        List<List<Integer>> nonFlat = List.of(List.of(1, 2, 3), List.of(4, 5), List.of(6, 7, 8));
        Set<Integer> set = new TreeSet<>(List.of(9,5,3,1,7,2,4,8));

        nonFlat.stream()
                //.peek(System.out::println)
                .flatMap(list -> list.stream())
                //.peek(System.out::println)
                //.limit(2)
                .forEach(System.out::println);

//        System.out.println(
        System.out.println(Queryable.of(set)
                .sorted(Comparator.naturalOrder())
                .map(p-> p * Math.random())
                .sorted(Comparator.reverseOrder())
                .peek(System.out::println)
                .allMatch(p-> p < 10));
    }
}
