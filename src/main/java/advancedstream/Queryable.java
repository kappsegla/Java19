package advancedstream;

import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

//https://github.com/fmcarvalho/quiny

//https://github.com/aNNiMON/Lightweight-Stream-API/tree/master/stream/src/main/java/com/annimon/stream

@FunctionalInterface
public interface Queryable<T> {

    static <T> boolean truth(Consumer<T> c, T item) {
        c.accept(item);
        return true;
    }

    public static <T> Queryable<T> of(Iterable<T> data) {
        final Iterator<T> dataSrc = data.iterator();
        return action -> dataSrc.hasNext() && truth(action, dataSrc.next());
    }

    public static <T> Queryable<T> iterate(final T seed, final UnaryOperator<T> f) {
        Objects.requireNonNull(f);
        return new Queryable<>(){
            T prev;
            boolean started;

            @Override
            public boolean tryAdvance(Consumer<? super T> action) {
                Objects.requireNonNull(action);
                T t;
                if (started)
                    t = f.apply(prev);
                else {
                    t = seed;
                    started = true;
                }
                action.accept(prev = t);
                return true;
            }
        };
    }

    abstract boolean tryAdvance(Consumer<? super T> action); // <=> Spliterator::tryAdvance

    public default void forEach(Consumer<? super T> action) {
        while (tryAdvance(action)) {
        }
    }

    public default long count() {
        final int[] count = {0};
        while (tryAdvance(item -> count[0]++)) ;
        return count[0];
    }

    public default <R> Queryable<R> map(Function<T, R> mapper) {
        return action -> tryAdvance(item -> action.accept(mapper.apply(item)));
    }


    public default <R> Queryable<R> flatMap(Function<T, Queryable<R>> mapper) {
        return action -> tryAdvance(item ->
        {
            Queryable<? extends R> result = mapper.apply(item);
            if (result != null) {
                do {
                } while (result.tryAdvance(action));
            }
        });

//        return action -> tryAdvance(item ->
//        {
//            Queryable<? extends R> result = mapper.apply(item);
//            if (result != null) {
//                do {
//                } while (result.tryAdvance(action));
//            }
//        });
    }


    public default Queryable<T> filter(Predicate<T> p) {
        return action -> {
            boolean[] found = {false};
            while (!found[0]) {
                boolean hasNext = tryAdvance(item -> {
                    //         System.out.println("in filter" + item);
                    if (p.test(item)) {
                        action.accept(item);
                        found[0] = true;
                    }
                });
                if (!hasNext) break;
            }
            return found[0];
        };
    }

    public default T reduce(T initial, BinaryOperator<T> accumulator) {
        final T[] res = (T[]) Array.newInstance(initial.getClass(), 1);
        res[0] = initial;
        while (tryAdvance(item ->
                res[0] = accumulator.apply(res[0], item)
        )) ;
        return res[0];
    }

    public default Queryable<T> peek(Consumer<T> consumer) {
        return action -> tryAdvance(item -> {
            consumer.accept(item);
            action.accept(item);
        });
    }

    public default Object[] toArray() {
        return toArray(Object[]::new);
    }

    public default <A> A[] toArray(IntFunction<A[]> generator) {
        final List<T> res = new ArrayList<>();
        while (tryAdvance(item -> res.add(item))) ;
        return res.toArray(generator.apply(res.size()));
    }

    public default Queryable<T> distinct() {
        final Set<T> selected = new HashSet<>();
        return action -> {
            boolean[] found = {false};
            while (!found[0]) {
                boolean hasNext = tryAdvance(item -> {
                    if (selected.add(item)) {
                        action.accept(item);
                        found[0] = true;
                    }
                });
                if (!hasNext) break;
            }
            return found[0];
        };
    }

    public default Optional<T> findFirst() {
        final Optional<T>[] res = (Optional<T>[]) Array.newInstance(Optional.class, 1);
        res[0] = Optional.empty();
        tryAdvance(item -> res[0] = Optional.of(item));
        return res[0];
    }

    //findLast doesn't exist in java streams.
    //Can be implemented with reduce
    public default Optional<T> findLast() {
        //Can we do this in a better way?
        final Optional<T>[] res = (Optional<T>[]) Array.newInstance(Optional.class, 1);
        res[0] = Optional.empty();
        while (tryAdvance(item -> res[0] = Optional.of(item))) ;
        return res[0];
    }

    //On ordered list, returns all items until predicate becomes false
    //In unordered list, undefined behavior...?
    public default Queryable<T> takeWhile(Predicate<T> p) {
        return action -> {
            boolean[] found = {false};
            while (!found[0]) {
                boolean hasNext = tryAdvance(item -> {
                    if (p.test(item)) {
                        action.accept(item);
                    }
                    else
                        found[0] = true;
                });
                if (!hasNext) break;
            }
            return false;
        };
    }

    public default Queryable<T> dropWhile(Predicate<T> p) {
        return null;
    }

    //Can we short circuit in some way when used with flatMap?
    public default Queryable<T> limit(long maxSize) {
        long[] count = {0};
        return action -> {
            //     System.out.println("in limit");
            boolean[] found = {false};
            while (!found[0]) {
                boolean hasNext = tryAdvance(item -> {
                    //                System.out.println("in limit: " + item);
                    if (count[0]++ < maxSize) {
                        action.accept(item);
                    } else
                        found[0] = true;
                });
                if (!hasNext || count[0] >= maxSize) break;
            }
            return false;
        };

//
//        final int[] count = {0};
//        return action -> {
//            System.out.println("in limit");
//            return count[0]++ < maxSize && tryAdvance(action);
//        };
    }

    public default Queryable<T> skip(long n) {
        long[] count = {n};
        return action -> {
            boolean[] found = {false};
            while (!found[0]) {
                boolean hasNext = tryAdvance(item -> {
                    //   System.out.println("in skip" + item);
                    if (count[0]-- < 1) {
                        action.accept(item);
                        found[0] = true;
                    }
                });
                if (!hasNext) break;
            }
            return found[0];
        };
    }

    /**
     * Creates a new List and sorts that list before returning it. Do not use on endless sources.
     */
    public default Queryable<T> sorted(Comparator<T> comparator) {
        List<T> list = new ArrayList<>();
        while (tryAdvance(i -> list.add(i))) ;
        list.sort(comparator);
        return Queryable.of(list);
    }

    /**
     * true if either no elements of the stream match the provided predicate
     * or the stream is empty, otherwise false
     */
    public default boolean nonMatch(Predicate<T> p) {
        boolean[] found = {false};
        while (!found[0]) {
            boolean hasNext = tryAdvance(item -> {
                if (p.test(item)) {
                    found[0] = true;
                }
            });
            if (!hasNext) break;
        }
        return !found[0];
    }

    public default boolean anyMatch(Predicate<T> p) {
        boolean[] found = {false};
        while (!found[0]) {
            boolean hasNext = tryAdvance(item -> {
                if (p.test(item)) {
                    found[0] = true;
                }
            });
            if (!hasNext) break;
        }
        return found[0];
    }

    public default boolean allMatch(Predicate<T> p) {
        boolean[] found = {true};
        while (found[0]) {
            boolean hasNext = tryAdvance(item -> {
                if (!p.test(item)) {
                    found[0] = false;
                }
            });
            if (!hasNext) break;
        }
        return found[0];
    }
}