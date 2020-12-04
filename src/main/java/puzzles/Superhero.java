package puzzles;

//Add comparable capabilities..

import org.jetbrains.annotations.NotNull;

import java.util.FormatFlagsConversionMismatchException;

public class Superhero implements Comparable<Superhero>{

    private Long strength;

    public Superhero(Long strength) {
        //null check here
        this.strength = strength;
    }

    public Long getStrength() {
        return strength;
    }

    //Formal parameters 8.4.1, from java9 we can now annotate this as any other parameter

    @Override
    public int compareTo(Superhero this, @NotNull Superhero that) {
        return 0;
    }
}
