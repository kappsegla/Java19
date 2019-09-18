package stream;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) throws IOException {

        //Create stream with static helper methods on Stream class
        System.out.println(IntStream.range(0, 10).sum());

        IntStream.iterate(2, (n) -> n * 2)
                .limit(10)
                .filter(t -> t > 2).max().ifPresent(i -> System.out.println(i));

        /////
        String[] array = new String[]{"1", "2", "3", "4"};
        //Stream from array
        long sum = Arrays.stream(array)
                .mapToInt(s -> Integer.parseInt(s))
                .sum();
        System.out.println(sum);

        /////
        Car[] cars = new Car[]{new Car("Volvo", 5), new Car("Saab", 1), new Car("Opel", 2)};

        System.out.println(Arrays.stream(cars)
                .peek(s->System.out.println("Before filter:" + s.getType()))
                .filter(car -> car.getType().equals("Volvo") || car.getType().equals("Opel"))
                .peek(s->System.out.println("After filter:" + s.getType()))
                .mapToInt(c -> c.getPassengers())
                .limit(1)
                .sum()
                );
        /////
        //List from array
        List<Car> carList = Arrays.asList(cars);

        Optional<Car> volvo = carList.stream()
                .filter(car -> car.getType().equals("Volvo"))
                .findFirst();

        if (volvo.isPresent())
            System.out.println(volvo.get().getType());

        /////
        //Java 11, Stream.of  List.of...
        //Stream.of(1,2,3,2,1).forEach(System.out::println);
        List<String> strings = List.of("1", "2", "3", "4");
        System.out.println(strings.stream().mapToInt(Integer::parseInt)
                .sum());

        /////
        //Create a stream of strings from a text file utf-8
        Path path = Paths.get("file.txt");
        Stream<String> streamOfStrings = Files.lines(path);
        var persons = streamOfStrings.skip(1).dropWhile(x -> x.startsWith("M")).map(StreamTest::stringToPerson)
                .collect(Collectors.toList());
        System.out.println(persons);
    }

    public static Person stringToPerson(String text) {
        String[] columns = text.split(",");
        return new Person(columns[0],Integer.parseInt(columns[1]),Integer.parseInt(columns[2]));
    }
}

class Person {
    private String name;
    private int age;
    private int iq;

    public Person(String name, int age, int iq) {
        this.name = name;
        this.age = age;
        this.iq = iq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", iq=" + iq +
                '}';
    }
}

class Car {
    private String type;
    private int passengers;

    public Car(String type, int passengers) {
        this.type = type;
        this.passengers = passengers;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
}
