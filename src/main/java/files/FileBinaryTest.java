package files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileBinaryTest {

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

        File filePath = new File(path + File.separator + "savefile.bin");

        List<Person> persons = new ArrayList<>();

        if (filePath.exists()) {
            try {
                FileInputStream inputStream = new FileInputStream(filePath);
                DataInputStream dataInputStream = new DataInputStream(inputStream);

                while( dataInputStream.available() > 0 ) {
                    String name = dataInputStream.readUTF();
                    int age = dataInputStream.readInt();
                    Person person = new Person(name,age);
                    persons.add(person);
                }
                dataInputStream.readInt();
                dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(persons);

        persons.add(new Person("Martin", 402343533));

        try {
            FileOutputStream outputStream = new FileOutputStream(filePath);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            for (Person p : persons) {
                dataOutputStream.writeUTF(p.getName());
                dataOutputStream.writeInt(p.getAge());
            }
            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
