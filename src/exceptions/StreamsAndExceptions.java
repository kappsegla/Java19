package exceptions;

import java.util.function.Function;
import java.util.stream.Stream;

public class StreamsAndExceptions {


    public static void main(String[] args) {
        var stream = Stream.of("1", "2", "3", "4", "5", "6", "a", "b", "c");

        long i = 0;
      //  i = stream.mapToInt( s->wrapper(s) ).sum();
      //  i = stream.map( wrap(  s -> parser(s)) ).mapToInt(Integer::intValue).sum();
   //     i = stream.mapToInt(s -> wrapper(s)).sum();
   //     i = stream.map(wrap( s -> parser(s))).mapToInt(Integer::intValue).sum();

        //Uses a Either monad
        //https://en.wikipedia.org/wiki/Monad_(functional_programming)
        //stream.map(  Either.lift(s -> parser(s))  ).forEach(System.out::println);
        i =  stream.map(  Either.lift(s -> parser(s))  )
                .filter(either -> either.isRight())
                .map(s-> s.getRight())
                .mapToInt(s -> (Integer) s.orElse(0))
                .sum();

        System.out.println(i);
    }
    public static Integer parser(String s) throws Exception {
        return Integer.parseInt(s);
    }

    public static int wrapper(String s) {
        try {
            return parser(s);
        } catch (Exception e) {
            //e.printStackTrace();
            return 0;
        }
    }

    public static <T,R> Function<T,R> wrap(CheckedFunction<T,R> checkedFunction) {
        return t -> {
            try {
                return checkedFunction.apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
