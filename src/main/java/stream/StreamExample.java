package stream;

import lamda.Person;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        new StreamExample().run();
    }

    private void run() {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Martin", 40));
        persons.add(new Person("Martin", 32));
        persons.add(new Person("Pelle", 20));
        persons.add(new Person("Stina", 27));
        persons.add(new Person("Maria", 15));
        persons.add(new Person("Anna", 40));
        persons.add(new Person("Pernilla", 33));
        persons.add(new Person("Ida", 11));
        persons.add(new Person("Adam", 74));
        persons.add(new Person("Maria", 16));


        //Stream creating
        //Stream operations
            //intermediate operations (return Stream<T>)
            //terminal operations (return a result of definite type).

        //How many persons in list
        long count = persons.stream().count();
        System.out.println(count);

        //Person with highest age
        Person person = persons.stream()
                .max(Comparator.comparing(Person::getAge))
                .orElseThrow(NoSuchElementException::new);
        System.out.println(person);

        //Find unique names https://stackoverflow.com/questions/23699371/java-8-distinct-by-property
        long ucount = persons.stream().filter(distinctByKey(Person::getName)).count();
        System.out.println(ucount);

        //Get a String list with all names
        List<String> names = persons.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(names);

        //Print all names
        persons.stream().map(Person::getName).forEach(System.out::println);

        Stream.iterate(0, i -> i + 1).limit(10).forEach(System.out::println);

        //Find first person with name Martin
        Person person1 = persons.stream().filter(p-> p.getName().equals("Martin")).findFirst().orElseThrow();
        System.out.println(person1);
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
