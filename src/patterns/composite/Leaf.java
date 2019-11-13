package patterns.composite;

public class Leaf implements Component {
    @Override
    public void printInfo() {
        System.out.println("I'm a leaf");
    }
}
