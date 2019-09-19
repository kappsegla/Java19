package exceptions;

import java.util.stream.Stream;

public class StreamsAndExceptions {


    public static void main(String[] args) {

        var stream = Stream.of("1", "2", "3", "4", "5", "6", "a", "b", "c");

        long i = 0;
        i = stream.mapToInt(s -> wrapper(s)).sum();

        System.out.println(i);
    }

    public static int wrapper(String s) {
        try {
            return parser(s);
        } catch (Exception e) {
            //e.printStackTrace();
            return 0;
        }
    }

    public static int parser(String s) throws Exception {
        return Integer.parseInt(s);
    }
}
