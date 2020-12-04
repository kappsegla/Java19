package patterns.visitor;

public class AnimalSoundVisitor implements Visitor {
    @Override
    public void visit(Cat animal) {
        System.out.println("Mjau");
    }

    @Override
    public void visit(Dog animal) {
        System.out.println("Bark");
    }
}
