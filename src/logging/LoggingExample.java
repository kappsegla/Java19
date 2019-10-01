package logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;



public class LoggingExample {

    //Include log4j library in project.http://logging.apache.org/log4j/2.x/download.html
    //log4j-api-2.12.1.jar
    //log4j-core-2.12.1.jar
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        try (InputStream inputStream = LoggingExample.class.getResourceAsStream("/file.txt")) {
            Scanner sc = new Scanner(inputStream);
            while (sc.hasNext()) {
                System.out.println(sc.nextLine());
                logger.debug("Found a line in file");
            }
        } catch (IOException e) {
            //TODO: log error
            logger.error(e.getMessage());
        }
        catch (NullPointerException e) {
            logger.fatal("Death to the program");
            logger.error("Null Pointer Exception in main method");
            logger.debug("This is a debug message");
            logger.warn("Warning!");
            logger.info("Info message");

            logger.log(Level.ERROR,"Logging error level with log method");
        }
    }
}
