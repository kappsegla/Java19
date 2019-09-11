package pets;

public class Horse implements LandBound, Journey {
    @Override
    public int numberOfLegs() {
        return 4;
    }
}
