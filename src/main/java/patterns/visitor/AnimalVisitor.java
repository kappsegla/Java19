package patterns.visitor;

public class AnimalVisitor implements Visitor {
    @Override
    public void visit(Cat animal) {
        System.out.println("Processing a cat");
    }

    @Override
    public void visit(Dog animal) {
        System.out.println("Processing a dog");
    }
}
