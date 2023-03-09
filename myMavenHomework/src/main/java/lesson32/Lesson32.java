package lesson32;

/**
 * Java Prof. Homework #30
 *
 * @author Dzmitry Kryvialeu
 * @version 06.03 - 09.03
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lesson32 {
    private static final Logger LOGGER = LogManager.getLogger(Lesson32.class);

    public static void main(String[] args) {
        // level FATAL
        LOGGER.fatal("log fatal");
        // level ERROR
        LOGGER.error("log error");
        // level WARM
        LOGGER.warn("log warn");
        // level INFO
        LOGGER.info("log info: {}", "Hello, world");
        // level DEBUG
        LOGGER.debug("log debug");
    }
}
