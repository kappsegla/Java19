package threads;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallellStream {

    public static void main(String[] args) {

        int ints = IntStream.range(0,10000)
                .parallel()
                .peek(ParallellStream::printInfo)
                .filter( x -> x < 5)
                .sum();

        System.out.println(ints);
    }

    private static void printInfo(Integer x) {
        System.out.println(x);
        System.out.println(Thread.currentThread().getName());
    }
}
