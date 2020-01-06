package advancedstream;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

//https://github.com/JosePaumard/streams-utils/tree/master/src/main/java/org/paumard/spliterators

public class SpliteratorExample {

    public static void main(String[] args) {

        var intStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        var groupingSpliterator = new GroupingSpliterator<>(3, intStream.spliterator());

        var groupedStream = StreamSupport.stream(groupingSpliterator, false);
        List<List<Integer>> collect = groupedStream.map(st -> st.collect(Collectors.toList())).collect(Collectors.toList());
        System.out.println(collect);
//-----------------
        Stream<String> stream1 = Stream.of("one", "two", "three");
        Stream<Integer> stream2 = Stream.of(1, 2, 3);

        var zippingSpliterator = new ZippingSpliterator<>(stream1.spliterator(), stream2.spliterator(), Two::new);

        var zipped = StreamSupport.stream(zippingSpliterator, false);
        zipped.forEach(System.out::println);
//-----------------
        Stream<String> stream3 = Stream.of("one", "two", "three");
        Stream<String> stream4 = Stream.of("1", "2", "3");

        var weavingSpliterator = new WeavingSpliterator<>(stream3.spliterator(), stream4.spliterator());

        var weaved = StreamSupport.stream(weavingSpliterator, false);
        weaved.forEach(System.out::println);
    }
}

class Two<T1, T2> {
    T1 t1;
    T2 t2;

    public Two(T1 t1, T2 t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public T1 getT1() {
        return t1;
    }


    public T2 getT2() {
        return t2;
    }

    @Override
    public String toString() {
        return "{" +
                "t1=" + t1 +
                ", t2=" + t2 +
                '}';
    }
}

class ZippingSpliterator<E1, E2, R> implements Spliterator<R> {
    private final Spliterator<E1> spliterator1;
    private final Spliterator<E2> spliterator2;
    private final BiFunction<? super E1, ? super E2, ? extends R> zipper;

    public ZippingSpliterator(Spliterator<E1> spliterator1, Spliterator<E2> spliterator2, BiFunction<? super E1, ? super E2, ? extends R> zipper) {
        this.spliterator1 = spliterator1;
        this.spliterator2 = spliterator2;
        this.zipper = zipper;
    }

    @Override
    public boolean tryAdvance(Consumer<? super R> action) {
        return spliterator1.tryAdvance(
                e1 -> {
                    spliterator2.tryAdvance(e2 -> {
                        action.accept(zipper.apply(e1, e2));
                    });
                });
    }

    @Override
    public Spliterator<R> trySplit() {
        Spliterator<E1> splitedSpliterator1 = spliterator1.trySplit();
        Spliterator<E2> splitedSpliterator2 = spliterator2.trySplit();

        return splitedSpliterator1 == null || splitedSpliterator2 == null ? null :
                new ZippingSpliterator<>(splitedSpliterator1, splitedSpliterator2, zipper);
    }

    @Override
    public long estimateSize() {
        return Long.min(spliterator1.estimateSize(), spliterator2.estimateSize());
    }

    @Override
    public int characteristics() {
        return this.spliterator1.characteristics() & this.spliterator2.characteristics() & ~Spliterator.SORTED;
    }
}

class GroupingSpliterator<E> implements Spliterator<Stream<E>> {
    private final long grouping;
    private final Spliterator<E> spliterator;

    private Stream.Builder<E> builder = Stream.builder();
    private boolean firstGroup = true;
    private boolean lastBuilderHasBeenConsumed = false;


    public GroupingSpliterator(long grouping, Spliterator<E> spliterator) {
        this.grouping = grouping;
        this.spliterator = spliterator;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Stream<E>> action) {
        //Should call action.accept() on next element of the Stream
        //Return true if more elements are to be consumed, false when we are done
        Stream.Builder<E> builder = Stream.builder();
        boolean finished = false;
        for (int i = 0; i < grouping; i++) {
            if (!spliterator.tryAdvance(element -> builder.add(element))) {
                finished = true;
                break;
            }
        }

        Stream<E> subStream = builder.build();
        action.accept(subStream);
        return !finished;
    }

    @Override
    public Spliterator<Stream<E>> trySplit() {
        Spliterator<E> spliterator = this.spliterator.trySplit();
        return new GroupingSpliterator<>(grouping, spliterator);
    }

    @Override
    public long estimateSize() {
        return spliterator.estimateSize() / grouping;
    }

    @Override
    public int characteristics() {
        return spliterator.characteristics();
    }
}

class WeavingSpliterator<E> implements Spliterator<E> {

    private final List<Spliterator<E>> spliterators = new ArrayList<>();
    //private final Spliterator<E> spliterator2;

    private final ArrayDeque<E> elements = new ArrayDeque<>();

    public WeavingSpliterator(Spliterator<E> spliterator1, Spliterator<E> spliterator2) {
        this.spliterators.add(spliterator1);
        this.spliterators.add(spliterator2);
    }

    private AtomicInteger whichOne  = new AtomicInteger();

    @Override
    public boolean tryAdvance(Consumer<? super E> action) {
        return spliterators.get(whichOne.getAndIncrement() % 2).tryAdvance(action);
    }

    @Override
    public Spliterator<E> trySplit() {
        Spliterator<E> splitedSpliterator1 = spliterators.get(0).trySplit();
        Spliterator<E> splitedSpliterator2 = spliterators.get(1).trySplit();

        return splitedSpliterator1 == null || splitedSpliterator2 == null ? null :
                new WeavingSpliterator<>(splitedSpliterator1, splitedSpliterator2);
    }

    @Override
    public long estimateSize() {
        return spliterators.get(0).estimateSize() + spliterators.get(1).estimateSize();
    }

    @Override
    public int characteristics() {
        return this.spliterators.get(0).characteristics() & this.spliterators.get(1).characteristics() & ~Spliterator.SORTED;
    }
}