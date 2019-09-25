package files;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileJsonTest {

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

        File filePath = new File(path + File.separator + "savefile.json");

        List<Person> persons = new ArrayList<>();
        Gson gson = new Gson();
        //https://github.com/google/gson/blob/master/UserGuide.md#TOC-Serializing-and-Deserializing-Generic-Types
        Type fooType = new TypeToken<ArrayList<Person>>() {
        }.getType();

        if (filePath.exists()) {
            try {
                FileReader fileReader = new FileReader(filePath);
                //We can't use generic types with fromJson direct. Use one of these methods instead:
                //persons = gson.fromJson(fileReader, fooType ); //Use a typeToken
                persons = gson.fromJson(fileReader, PersonList.class ); //Extend ArrayList<Person> as a non generic class
                //persons = getList(fileReader,Person.class);  //Helper method that encapsulates typeToken.
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println(persons);

        persons.add(new Person("Martin", 402343533));

        String json = gson.toJson(persons, fooType);

        try {
            FileWriter out = new FileWriter(filePath);
            out.write(json);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> getList(FileReader fileReader, Class<T> clazz) {
        Type typeOfT = TypeToken.getParameterized(List.class, clazz).getType();
        return new Gson().fromJson(fileReader, typeOfT);
    }
}

