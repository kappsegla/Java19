package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
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
                .filter(car -> car.getType().equals("Volvo") || car.getType().equals("Opel"))
                .mapToInt(c -> c.getPassengers())
                .sum());
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
    //    Stream.of(1,2,3,2,1).forEach(System.out::println);

        List<String> strings = List.of("1","2","3","4");
        System.out.println(strings.stream().mapToInt(Integer::parseInt)
                .sum());

        /////
        Path path = Paths.get("file.txt");
        Stream<String> streamOfStrings = Files.lines(path);

        System.out.println( streamOfStrings.count() );



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
