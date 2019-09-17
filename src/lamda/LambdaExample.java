package lamda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExample {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Martin", 40));
        persons.add(new Person("Martin", 32));
        persons.add(new Person("Pelle", 20));
        persons.add(new Person("Stina", 27));
        persons.add(new Person("Maria", 15));

        //Implementation of Comparator as own class
        persons.sort(new SortPersonsByName());

        //Anonymous class implementation
        persons.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        //Lambda implementation of functional interface Comparator
        persons.sort((o1, o2) -> o2.getAge() - o1.getAge());



        System.out.println(persons);

    }
}
