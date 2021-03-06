package test.java.advancedstream;

import advancedstream.Queryable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class QueryableTest {

    List<List<Integer>> nonFlat = List.of(List.of(1, 2, 3), List.of(4, 5), List.of(6, 7, 8));
    List<Integer> unSorted = List.of(5, 6, 2, 1, 10, 34, 5);

    @Test
    void flatMapReturnsFlattenedData() {

        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        Queryable.of(nonFlat)
                .flatMap(Queryable::of)
                .forEach(actual::add);

        assertEquals(expected, actual);
    }

    @Test
    void limitThenFlatMap() {

        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = List.of(1, 2, 3, 4, 5);

        Queryable.of(nonFlat)
                .limit(2)
                .flatMap(Queryable::of)
                .forEach(actual::add);

        assertEquals(expected, actual);
    }

    @Test
    void flatMapThenLimit() {

        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = List.of(1, 2);

        Queryable.of(nonFlat)
                .flatMap(Queryable::of)
                .limit(2)
                .forEach(actual::add);

        assertEquals(expected, actual);
    }

    @Test
    void flatMapThenSkip() {

        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = nonFlat.stream().flatMap(Collection::stream).skip(2).collect(Collectors.toList());

        Queryable.of(nonFlat)
                .flatMap(Queryable::of)
                .skip(2)
                .forEach(actual::add);

        assertEquals(expected, actual);
    }

    @Test
    void skipThenflatMap() {

        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = nonFlat.stream().skip(2).flatMap(Collection::stream).collect(Collectors.toList());

        Queryable.of(nonFlat)
                .skip(2)
                .flatMap(Queryable::of)
                .forEach(actual::add);

        assertEquals(expected, actual);
    }

    @Test
    void onlySortReturnsSortedOrder() {

        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = unSorted.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());

        Queryable.of(unSorted)
                .sorted(Comparator.naturalOrder())
                .forEach(actual::add);

        assertEquals(expected, actual);
    }

    @Test
    void sortFilterSort() {

        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = unSorted.stream()
                .sorted(Comparator.naturalOrder())
                .map(p-> p * p -3)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        Queryable.of(unSorted)
                .sorted(Comparator.naturalOrder())
                .map(p-> p * p -3)
                .sorted(Comparator.reverseOrder())
                .forEach(actual::add);

        assertEquals(expected, actual);
    }


}