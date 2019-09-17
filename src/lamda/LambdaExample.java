package lamda;

import java.util.ArrayList;
import java.util.List;

public class LambdaExample {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Martin", 40));
        persons.add(new Person("Martin", 32));
        persons.add(new Person("Pelle", 20));
        persons.add(new Person("Stina", 27));
        persons.add(new Person("Maria", 15));

        persons.sort(new SortPersonsByName());
    }
}
