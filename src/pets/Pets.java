package pets;

import java.util.ArrayList;
import java.util.List;

public class Pets {
    public static void main(String[] args) {
        //Use List interface for reference. Allows us to change the Implementation type easily
        //Can use LinkedList instead
        List<Pet> pets = new ArrayList<>();

        Horse h = new Horse();
        LandBound landBound = h;
        System.out.println(landBound.numberOfLegs());
        Journey journey = h;
        System.out.println(journey.numberOfLegs());

        Mammal mammal = new Cat();
        mammal.numberOfLegs();

        Pet pet = new Cat();
        Pet pet1 = new Dog();

        if (pet instanceof Cat) {
            System.out.println("Pet is a Cat");
            Cat cat = (Cat) pet;
        } else
            System.out.println("Pet is not a Cat");

        pets.add(pet);
        pets.add(pet1);

        System.out.println(pet.isCute());
        System.out.println(pet1.isCute());
    }
}
