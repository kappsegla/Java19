package advancedstream;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

//https://github.com/fmcarvalho/quiny

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
                do { } while (result.tryAdvance(action));
            }
        });
    }


        public default Queryable<T> limit ( long maxSize){
            final int[] count = {0};
            return action -> count[0]++ < maxSize ? tryAdvance(action) : false;
        }

        public default Queryable<T> filter (Predicate < T > p) {
            return action -> {
                boolean[] found = {false};
                while (!found[0]) {
                    boolean hasNext = tryAdvance(item -> {
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

        public default T reduce (T initial, BinaryOperator < T > accumulator){
            final T[] res = (T[]) Array.newInstance(initial.getClass(), 1);
            res[0] = initial;
            while (tryAdvance(item ->
                    res[0] = accumulator.apply(res[0], item)
            )) ;
            return res[0];
        }

        public default Queryable<T> peek (Consumer < T > consumer) {
            return action -> tryAdvance(item -> {
                consumer.accept(item);
                action.accept(item);
            });
        }

        public default Object[] toArray () {
            return toArray(Object[]::new);
        }

        public default <A > A[]toArray(IntFunction < A[]>generator){
            final List<T> res = new ArrayList<>();
            while (tryAdvance(item -> res.add(item))) ;
            return res.toArray(generator.apply(res.size()));
        }

        public default Queryable<T> distinct () {
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

        public default Optional<T> findFirst () {
            final Optional<T>[] res = (Optional<T>[]) Array.newInstance(Optional.class, 1);
            res[0] = Optional.empty();
            tryAdvance(item -> res[0] = Optional.of(item));
            return res[0];
        }

        //findLast doesn't exist in java streams.
        //Can be implemented with reduce
        public default Optional<T> findLast () {
            //Can we do this in a better way?
            final Optional<T>[] res = (Optional<T>[]) Array.newInstance(Optional.class, 1);
            res[0] = Optional.empty();
            while (tryAdvance(item -> res[0] = Optional.of(item))) ;
            return res[0];
        }


    }