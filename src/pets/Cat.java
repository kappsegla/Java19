package pets;

import java.io.Serializable;

public class Cat implements Pet, LegInfo {

    @Override
    public boolean isCute() {
        return true;
    }

    @Override
    public int numberOfLegs() {
        return 4;
    }

}
