package patterns.visitor;


//https://sourcemaking.com/design_patterns/visitor

public interface Visitor {
    void visit(Cat animal);
    void visit(Dog animal);
}
