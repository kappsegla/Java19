package files.example;

import books.Author;
import exceptions.CheckedConsumer;
import exceptions.CheckedFunction;
import exceptions.StreamsAndExceptions;
import files.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class FileTest extends FileTestTest {
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
        List<Author> authors = new ArrayList<>();

        persons.add(new Person("Martin", 402343533));
        authors.add(new Author("Arne", "Anka"));
        authors.add(new Author("Sven", "Melander"));

        if (filePath.exists()) {
            importFile(filePath, persons);
        }
        //System.out.println(persons);

        //Export
        //exportFile(filePath, persons);
        //   FileExporter fileExporter = new PersonFileExporter(persons);
        //   fileExporter.exportFile(filePath);

        Exporter exporter = new Exporter();
        exporter.exportFile(filePath, wrap(fileWriter -> {
            for (Person p : persons) {
               fileWriter.write(p.getName() + "," + p.getAge() + "\n");
            }
        }));

        File authorsFilePath = new File(path + File.separator + "authors.csv");
        //exportAuthorsFile(authorsFilePath, authors);
        //fileExporter = new AuthorFileExporter(authors);
        //fileExporter.exportFile(authorsFilePath);
        exporter.exportFile(authorsFilePath, wrap(fileWriter -> {
            for (Author a : authors) {
                fileWriter.write(a.getFirstName() + "," + a.getLastName() + "\n");
            }
        }));
    }

    private static void importFile(File filePath, List<Person> persons) {
        try (Scanner sc = new Scanner(filePath)) {
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

    private static void exportFile(File filePath, List<Person> persons) {
        try (FileWriter out = new FileWriter(filePath)) {
            for (Person p : persons) {
                out.write(p.getName() + "," + p.getAge() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void exportAuthorsFile(File filePath, List<Author> authors) {
        try (FileWriter out = new FileWriter(filePath)) {
            for (Author a : authors) {
                out.write(a.getFirstName() + "," + a.getLastName() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> Consumer<T> wrap(CheckedConsumer<T> checkedFunction) {
        return t -> {
            try {
                checkedFunction.apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}

class Exporter {
    public void exportFile(File filePath, Consumer<FileWriter> impl) {
        try (FileWriter out = new FileWriter(filePath)) {
            //write to file
            impl.accept(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

abstract class FileExporter {
    public void exportFile(File filePath) {
        try (FileWriter out = new FileWriter(filePath)) {
            writeToFile(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void writeToFile(FileWriter out) throws IOException;
}

class PersonFileExporter extends FileExporter {
    private final List<Person> personList;

    public PersonFileExporter(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public void writeToFile(FileWriter out) throws IOException {
        for (Person p : personList) {
            out.write(p.getName() + "," + p.getAge() + "\n");
        }
    }
}

class AuthorFileExporter extends FileExporter {
    private final List<Author> authorsList;

    public AuthorFileExporter(List<Author> authorsList) {
        this.authorsList = authorsList;
    }

    @Override
    public void writeToFile(FileWriter out) throws IOException {
        for (Author a : authorsList) {
            out.write(a.getFirstName() + "," + a.getLastName() + "\n");
        }
    }
}
