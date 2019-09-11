package pets;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pets {
    public static void main(String[] args) {
        List<Pet> pets = new ArrayList<>();

        Cat pet = new Cat();
        Dog pet1 = new Dog();

        if( pet instanceof Pet)
            System.out.println("Cat is a Pet");

      //  pets.sort(new SortPetsInAlfabeticOrder());
      //  pets.sort(new SortPetsAccordingToCuteness());

        pets.add(pet);
        pets.add(pet1);


        pet.isCute();
        pet1.isCute();
    }
}
