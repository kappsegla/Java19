package logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;



public class LoggingExample {

    //Include log4j library in project.http://logging.apache.org/log4j/2.x/download.html
    //log4j-api-2.12.1.jar
    //log4j-core-2.12.1.jar
    private static final Logger logger = LogManager.getLogger(LoggingExample.class.getName());

    public static void main(String[] args) {

        try (InputStream inputStream = LoggingExample.class.getResourceAsStream("/file2.txt")) {
            Scanner sc = new Scanner(inputStream);
            while (sc.hasNext())
                System.out.println(sc.nextLine());
        } catch (IOException e) {
            //TODO: log error
            logger.error(e.getMessage());
        }
        catch (NullPointerException e) {
            logger.error("Null Pointer Exception in main method");
        }
    }
}
