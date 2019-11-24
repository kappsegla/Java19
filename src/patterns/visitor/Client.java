package patterns.visitor;

import java.util.List;

public class Client {

    public static void main(String[] args) {
        List<Animal> animals  = List.of( new Dog(), new Cat(), new Dog(), new Dog(), new Cat() );

        AnimalVisitor animalVisitor = new AnimalVisitor();

        //How to know if it's a cat or dog type?
        for (Animal animal : animals) {
            if( animal instanceof Cat){

            }
            else if( animal instanceof Dog){

            }
         //   animal.accept(animalVisitor);
        }
    }
}
