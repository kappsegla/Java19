package advancedstream.monads;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TryTest {

    @Test
    void useTryWithMethodThrowingException(){

        String s = null;

        var result = Try.ofThrowable(()-> s.isEmpty()).orElse(false);
        assertFalse(result);
    }

}