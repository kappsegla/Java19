package exceptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLDataException;
import java.util.Scanner;

public class ExceptionsExample {


    public static void main(String[] args) {

        //This code will be run last when the application is shutting down.
        //Do cleanup here, save unsaved changes.
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> System.out.println("Shutdown Hook is running !")));

        int x = 0;
        int y = 0;
        try {
            x = divide(y);
            System.out.println("Will this be done?");
        } catch (ArithmeticException e) {
            System.out.println("Catch");
            e.printStackTrace();
            //System.exit(0);  //Will not run finally
            //return;          //Will run finally
        } finally {
            System.out.println("Finally");
        }
        System.out.println("More to do!" + x);
    }

    private static int divide(int value) {
        return 1 / value;
    }

    private static void test() throws IOException {
        throw new IOException("");
    }

}
