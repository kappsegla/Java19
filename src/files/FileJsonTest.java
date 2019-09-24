package files;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

            if (filePath.exists()) {
                //TODO: Load from Json file

            }
            System.out.println(persons);

            persons.add(new Person("Martin", 402343533));

            //TODO: Save as Json to file
            Gson gson = new Gson();
            String json = gson.toJson(persons);

            try {
                FileWriter out = new FileWriter(filePath);
                out.write(json);
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

