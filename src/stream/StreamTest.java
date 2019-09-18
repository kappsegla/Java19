package stream;

import java.util.*;
import java.util.stream.IntStream;

public class StreamTest {
    public static void main(String[] args) {

        System.out.println(IntStream.range(0, 10).sum());


        IntStream.iterate(2, (n) -> n * 2)
                .limit(10)
                .filter(t -> t > 2).max().ifPresent(i -> System.out.println(i));

        String[] array = new String[]{"1", "2", "3", "4"};

        long sum = Arrays.stream(array)
                .mapToInt(s -> Integer.parseInt(s))
                .sum();
        System.out.println(sum);

        Car[] cars = new Car[]{new Car("Volvo", 5), new Car("Saab", 1), new Car("Opel", 2)};

        System.out.println(Arrays.stream(cars)
                .filter(car -> car.getType().equals("Volvo") || car.getType().equals("Opel"))
                .mapToInt(c -> c.getPassengers())
                .sum());

        List<Car> carList = Arrays.asList(cars);

        Optional<Car> volvo = carList.stream()
                .filter(car -> car.getType().equals("Volvo"))
                .findFirst();

        if( volvo.isPresent())
            System.out.println(volvo.get().getType());

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
