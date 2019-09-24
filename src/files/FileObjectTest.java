package files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileObjectTest {

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
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

                persons = (List<Person>) objectInputStream.readObject();
                objectInputStream.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println(persons);

        persons.add(new Person("Martin", 402343533));

        try {
            FileOutputStream outputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(persons);

            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
