package puzzles.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Test
    public void testWithNumberIsDividableBy3() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
    }

    @Test
    public void testWithNumberIsDividableBy5() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
    }

    @Test
    public void testWithNumberIsDividableBy15() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(45));
    }

    @Test
    public void testOtherNumbers() {
        assertEquals("1", FizzBuzz.fizzBuzz(1));
        assertEquals("7", FizzBuzz.fizzBuzz(7));
    }
}