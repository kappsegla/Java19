package files;

import java.io.*;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.util.Scanner;

public class FileTest {
    public static void main(String[] args) {

//        InputStream inputStream = FileTest.class.getResourceAsStream("/file.txt");
//
//        Scanner scanner = new Scanner(inputStream);
//        System.out.println( scanner.nextLine() );
        //Absolute path
//        File filePath = new File("C:\\Users\\Martin\\Documents\\GitHub\\Java19\\resources\\file.txt");
        //Relative path
        File filePath = new File("..\\Java19\\resources\\file.txt");
        try {
          //  FileReader in = new FileReader(filePath);
            Scanner sc = new Scanner(filePath);
            while (sc.hasNext())
                System.out.println(sc.nextLine());
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String path = System.getProperty("user.home") +
                File.separator + "Documents" +
                File.separator + "CustomFolder";

        File dir = new File(path);

        if( dir.exists() )
            System.out.println("Folder exists");
        else if(dir.mkdir())
            System.out.println("Folder created");
        else
            System.out.println("Folder not created");

        File filePath2 = new File(path + File.separator + "outputfile.txt");
        try {
            FileWriter out = new FileWriter(filePath2,false);
            out.write("Test");
           // out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
