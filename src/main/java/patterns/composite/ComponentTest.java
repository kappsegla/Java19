package patterns.composite;

public class ComponentTest {

    public static void main(String[] args) {

        Composite rootNode = new Composite();

        rootNode.addComponent(new Leaf());
        rootNode.addComponent(new Leaf());

        var c = new Composite();
        c.addComponent(new Leaf());
        c.addComponent(new Leaf());

        rootNode.addComponent(c);


        rootNode.printInfo();




    }
}
