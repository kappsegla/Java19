package files.example;

import files.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileTest {
    public static void main(String[] args) {
        String path = System.getProperty("user.home") +
                File.separator + "Documents" +
                File.separator + "CustomFolder";

        File dir = new File(path);

        if (dir.exists())
            System.out.println("Folder exists");
        else if (dir.mkdir())
            System.out.println("Folder created");
        else
            System.out.println("Folder not created");

        File filePath = new File(path + File.separator + "savefile.csv");

        List<Person> persons = new ArrayList<>();

        if (filePath.exists()) {
            try(Scanner sc = new Scanner(filePath);) {
                while (sc.hasNext()) {
                    String line = sc.nextLine();
                    String[] fields = line.split(",");
                    Person person = new Person(fields[0], Integer.parseInt(fields[1]));
                    persons.add(person);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println(persons);

        persons.add(new Person("Martin", 402343533));

        try (FileWriter out = new FileWriter(filePath)) {
            for (Person p : persons) {
                out.write(p.getName() + "," + p.getAge() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
