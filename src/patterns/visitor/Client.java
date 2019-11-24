package patterns.visitor;

import java.util.List;

public class Client {

    public static void main(String[] args) {
        List<Animal> animals  = List.of( new Dog(), new Cat(), new Dog(), new Dog(), new Cat() );

        AnimalVisitor animalVisitor = new AnimalVisitor();

        for (Animal animal : animals) {
            animal.accept(animalVisitor);
        }
    }
}
