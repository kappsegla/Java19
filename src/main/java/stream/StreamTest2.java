package stream;

import lamda.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamTest2 {

    public static void main(String[] args) {

        var list = List.of("a", "aa", "aaa", "aaaaa", "aaaaa", "b", "bb", "bbb", "bbbb", "bbbbb");

        //Find length of longest string
        System.out.println(list.stream().mapToInt(s -> s.length()).max().getAsInt());

        //Find longest string object using reduction
        System.out.println(list.stream()
                .reduce(StreamTest2::apply)
                .orElse(""));
        //Find longest string object with max function
        System.out.println(list.stream()
                .max(String::compareTo)
                .orElse(""));

        //Sum of double stream
        var dStream = DoubleStream.of(10.0, 10.0, 20.0, 20.0);
        System.out.println(dStream.sum());

        //Sum implemented with reduce
        dStream = DoubleStream.of(10.0, 10.0, 20.0, 20.0);
        System.out.println(dStream.reduce((d, d2) -> d + d2).orElse(0.0));

        //Max implemented with reduce
        dStream = DoubleStream.of(10.0, 10.0, 20.0, 20.0);
        System.out.println(dStream.reduce((d, d2) -> {
            if (d > d2) return d;
            return d2;
        }).orElse(0.0));

        //Average
        dStream = DoubleStream.of(10.0, 10.0, 20.0, 20.0);
        System.out.println(dStream.average().orElse(0.0));

        dStream = DoubleStream.of(10.0, 10.0, 20.0, 20.0);
        System.out.println(dStream.summaryStatistics());


        //Find distinct numbers
        var sStream = Stream.of("1", "2", "1", "2", "1", "2");
        sStream.distinct().forEach(System.out::println);

        List<lamda.Person> persons = new ArrayList<>();
        persons.add(new lamda.Person("Martin", 40));
        persons.add(new lamda.Person("Martin", 32));
        persons.add(new lamda.Person("Pelle", 20));
        persons.add(new lamda.Person("Stina", 27));
        persons.add(new lamda.Person("Maria", 15));
        persons.add(new lamda.Person("Anna", 40));
        persons.add(new lamda.Person("Pernilla", 33));
        persons.add(new lamda.Person("Ida", 11));
        persons.add(new lamda.Person("Adam", 74));
        persons.add(new Person("Maria", 16));

        persons.stream().peek(person -> person.setName("hihi"))
                .map(Person::getName)
                .distinct()
                .forEach(System.out::println);

    }

    private static String apply(String s, String s2) {
        if (s.length() >= s2.length())
            return s;
        else
            return s2;
    }
}
