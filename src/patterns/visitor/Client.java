package patterns.visitor;

import java.util.List;

public class Client {

    public static void main(String[] args) {
        List<Animal> animals = List.of(new Dog(), new Cat(), new Dog(), new Dog(), new Cat());

       // Visitor animalVisitor = new AnimalVisitor();
        Visitor animalVisitor = new AnimalSoundVisitor();

        //How to know if it's a cat or dog type?
        for (Animal animal : animals) {
            animal.accept(animalVisitor);
        }
    }
}
