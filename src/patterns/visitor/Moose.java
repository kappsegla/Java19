package patterns.visitor;

public class Moose implements Animal {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
