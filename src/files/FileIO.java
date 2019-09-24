package files;

import books.Author;
import books.Book;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileIO {

    public static void readTextFileFromResources() throws IOException {
        try (InputStream inputStream = FileIO.class.getResourceAsStream("/file2.txt")) {
            Scanner sc = new Scanner(inputStream);
            while (sc.hasNext())
                System.out.println(sc.nextLine());
        }
    }

    public static void readTextFileFromAbsolutePath() {
        //File file = new File("C:\\Users\\Martin\\Documents\\code.txt");
        String path = System.getProperty("user.home")
                + File.separator + "Documents"
                + File.separator + "code.txt";
        File file = new File(path);

        try {
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext())
                System.out.println(scanner.nextLine());
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes information to a textfile
     *
     * @param file File to write to
     * @param text String with text to write to file
     */
    public static void writeTextFile(File file, String text) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readTextFileWithEncoding() {
        File file = new File("C:\\Users\\Martin\\Documents\\code.txt");

        try {
            FileInputStream inputStream = new FileInputStream(file);
            Scanner scanner = new Scanner(inputStream, "UTF-8");
            while (scanner.hasNext())
                System.out.println(scanner.nextLine());
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void propertiesSavingLoading() {
        String path = System.getProperty("user.home")
                + File.separator + "Documents"
                + File.separator + "FileInput"
                + File.separator + "settings.xml";
        File file = new File(path);

        Properties properties = new Properties();

        try {
            FileInputStream inputStream = new FileInputStream(file);
            properties.loadFromXML(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(properties.getProperty("AutoSave"));
        //Spara en inställning
        //properties.setProperty("AutoSave","true");

        //Hämta en inställning med default som false om nyckeln inte finns
        //String autoSave = properties.getProperty("AutoSave", "false");


        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            properties.storeToXML(outputStream, "Settings for FileInput Invoker");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static List<String> names() {

        // String path = "/file.txt";
        File file = new File("C:\\Users\\Martin\\Documents\\code.txt");
        //URL url = FileInput.class.getResource("/file.txt");
        try (Stream<String> stream = Files.lines(Paths.get(file.toURI()))) {

            return stream.distinct().filter(string -> string.matches("[A].*")).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveBinaryData(File file, double d) {

        try (DataOutputStream outputStream
                     = new DataOutputStream(new FileOutputStream(file))) {
            outputStream.writeDouble(d);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double loadBinaryData(File file) {
        try (DataInputStream inputStream
                     = new DataInputStream(new FileInputStream(file))) {
            return inputStream.readDouble();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0.0;
    }


    public void save(String filename, Object object) {

    }

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Book book = new Book("Java for Dummies",new Author("Martin","Nordväst"),"Learn Java now.",345, LocalDate.now());
        books.add(book);

        File file = new File("C:\\Users\\Martin\\Documents\\books.bin");

        //Save object to file
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            out.writeObject(books);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Load from file
        try (ObjectInputStream in =
                     new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            ArrayList<Book> b = (ArrayList<Book>) in.readObject();
            System.out.println(b.get(0));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


//        File file = new File("C:\\Users\\Martin\\Documents\\binary.bin");
//        saveBinaryData(file, 1234.56789);
//
//        System.out.println(loadBinaryData(file));
//


//        try {
//            readTextFileFromResources();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //readTextFileFromAbsolutePath();
        //readTextFileWithEncoding();

        //   List<String> names = names();
        //   names.forEach(System.out::println);


    }

}
