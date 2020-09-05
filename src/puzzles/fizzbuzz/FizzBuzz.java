//package puzzles.fizzbuzz;
//
////import lombok.Data;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Function;
//import java.util.stream.Stream;
//
////https://www.sitepoint.com/functional-fizzbuzz-with-vavr/
//public class FizzBuzz {
//
//    //Imperative version
//    public void fizzBuzzFrom1to100() {
//        for (int i = 1; i <= 100; i++) {
//            if (i % 3 == 0 && i % 5 == 0) {
//                System.out.println("FizzBuzz");
//            } else if (i % 3 == 0) {
//                System.out.println("Fizz");
//            } else if (i % 5 == 0) {
//                System.out.println("Buzz");
//            } else {
//                System.out.println(i);
//            }
//        }
//    }
//
//    public List<String> fizzBuzz(int amount) {
//        List<String> ret = new ArrayList<>();
//        for (int i = 1; i <= amount; i++) {
//            if (i % 3 == 0 && i % 5 == 0) {
//                ret.add("FizzBuzz");
//            } else if (i % 3 == 0) {
//                ret.add("Fizz");
//            } else if (i % 5 == 0) {
//                ret.add("Buzz");
//            } else {
//                ret.add(String.valueOf(i));
//            }
//        }
//        return ret;
//    }
//
//    static Function<Integer, String> fizzBuzz() {
//        return i -> {
//            if (i % 3 == 0 && i % 5 == 0) {
//                return "FizzBuzz";
//            } else if (i % 3 == 0) {
//                return "Fizz";
//            } else if (i % 5 == 0) {
//                return "Buzz";
//            } else {
//                return i.toString();
//            }
//        };
//    }
//
//
////    static Function<Integer, String> withPatternMatching() {
////        return (e) -> {
////            switch (Pair.of(e % 3, e % 5)) {
////                case Pair.of(0, 0) -> "FizzBuzz";
////                case Pair.of(0, "") -> "Fizz";
////                case Pair.of(0, "") -> "Fizz";
////            }
////        };
//////
//////        return e -> Match(Tuple.of(e % 3, e % 5)).of(
//////                Case(Tuple2($(0), $(0)), "FizzBuzz"),
//////                Case(Tuple2($(0), $()), "Fizz"),
//////                Case(Tuple2($(), $(0)), "Buzz"),
//////                Case($(), e.toString())
//////        );
////    }
//
//    public static void main(String[] args) {
//
//    }
//
//    @Data(staticConstructor = "of")
//    public class Pair<A, B> {
//        private final A left;
//        private final B right;
//    }
//}
