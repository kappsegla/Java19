package pets;

import java.io.Serializable;

public class Cat extends Mammal implements Pet {

    @Override
    public boolean isCute() {
        return true;
    }

    @Override
    public boolean laysEggs() {
        return false;
    }
}
