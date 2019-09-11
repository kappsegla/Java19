package pets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pets {
    public static void main(String[] args) {
        List<Pet> pets = new ArrayList<>();

        Pet pet = new Cat();
        Pet pet1 = new Dog();

        pets.add(pet);
        pets.add(pet1);


        pet.isCute();
        pet1.isCute();
    }
}
