package retail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

/**
 * @author Loic Talhouarne
 *         <p>
 *         Class implementing Banner to print a custom Banner on Launch
 */
public class AppCustomBanner implements Banner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppCustomBanner.class);

    private static final String[] BANNER = {"                ______      _        _ _", "                | ___ \\    | |     (_) |", " _ __ ___  _   _| |_/ /___ | |___ _ _| |", "| '_ ` _ \\| | | |    // _ \\ __/ _` | | |", "| | | | | | |_| | |\\ \\  __/ || (_| | | |",
            "|_| |_| |_|\\__, \\_| \\_\\___|\\__\\__,_|_|_|", "            __/ |", "           |___/"};

    /**
     * Print custom banner with version number of all the libraries used in this
     * application
     */
    @Override
    public void printBanner(Environment arg0, Class<?> sourceClass, PrintStream printStream) {
        returnProperties();

        for (String line : BANNER) {
            printStream.println(line);
        }

        printStream.println();
    }

    /**
     * @return Need to natively read through properties since the printBanner
     * method is called prior to the initialization of the beans.
     */
    private Properties returnProperties() {
        Properties properties = new Properties();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.error("Error reading through the application's property file.");
        }
        return properties;
    }

}
