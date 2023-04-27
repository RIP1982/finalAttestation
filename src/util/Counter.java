package util;


import java.util.logging.Logger;

public class Counter implements AutoCloseable {

    static int sum;
    {
        sum = 0;
    }

    public void add() {
        sum++;
    }

    @Override
    public void close() {
        Logger logger = Logger.getAnonymousLogger();
        logger.info("Counter closed");
    }
}




