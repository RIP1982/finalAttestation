package util;


import java.util.logging.Logger;

public class Counter implements AutoCloseable{

    private static int sum;
    {
        sum = 0;
    }

    public static void add() {
        sum++;
    }

    @Override
    public void close() {
        Logger logger = Logger.getAnonymousLogger();
        logger.info("Counter closed");
    }

    @Override
    public String toString() {
        return "{counter = " + sum + '}';
    }
}




