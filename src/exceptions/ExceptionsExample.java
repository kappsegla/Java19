package exceptions;

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
                 x = 1 / y;
            System.out.println("Will this be done?");
        } catch (ArithmeticException e) {
            e.printStackTrace();
            //System.exit(0);  //Will not run finally
            //return;          //Will run finally
        }
        finally {
            System.out.println("Always doing this");
        }
        System.out.println("More to do!" + x);
    }
}
