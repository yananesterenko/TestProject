package com.project.utils;

import java.util.Formatter;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class MyLogger {
    public static Logger getLogger(){
        Handler handler = new ConsoleHandler();
        Logger logger = Logger.getLogger("MyLogger");
        logger.setUseParentHandlers(false);
        logger.addHandler(handler);
        return logger;
    }

    /*static class MyFormatter extends Formatter{


    }*/
}
