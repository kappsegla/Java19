package lamda;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;

public class LambdaExample {
    private String text = "Hej";
    private int i = 1;
    Consumer<String> forLaterUse;

    public void printValue(MyValue myVal) {
        System.out.println(myVal.getValue());
    }

    public void printValue(double d, DoubleFunction<Double> proc) {
        System.out.println(proc.apply(d));
    }

    public void doSomething(Consumer<String> consumer) {
        forLaterUse = consumer;
        //consumer.accept("Test");
        forLaterUse.accept("Later");
    }

    public void run() {
        int k = 20;

        doSomething(s -> System.out.println(text));
        doSomething(s -> System.out.println(s.length()));
        doSomething(s -> {
            text = "olle";
            //k = s.length();
            System.out.println(text + k * 2);
        });
    }


    public static void main(String[] args) {
//        LambdaExample le = new LambdaExample();
//
//        le.run();
//
//        le.printValue(20.0, tal -> tal * 10.0);
//        le.printValue(20.0, tal -> tal * 2.0);
//
//        le.printValue(() -> 100.0);
//
//        MyValue myValue = () -> 95.6;
//        le.printValue(myValue);
//        le.printValue(myValue);





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
        persons.sort( (o1, o2) -> o2.getAge() - o1.getAge());

        System.out.println(persons);

    }
}
