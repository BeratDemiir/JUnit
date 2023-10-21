package day18_for4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C01_Log4J {

    //    Logger object olustur:
//        private static Logger logger = LogManager.getLogger(Demo1.class.getName());
//        Logger fonksiyonuyla istenilen fonksiyonu kullan
//        logger.debug("Debug logger");
//        logger.info("Info logger");
//        logger.error("Error logger");
//        logger.fatal("Fatal logger");
//        Consoldeki loglari kontrol edelim. Default olarak error or fatal gorunmus olacaktır

    private static Logger logger = LogManager.getLogger(C01_Log4J.class.getName());
    @Test
    public void log4JTest() {
        // Logger fonksiyonuyla istenilen fonksiyonu kullan
        logger.fatal("Fatal Log!");
        logger.error("Error Log!");
        logger.warn("Warn Log!");
        logger.debug("Debug Log!");
        logger.info("Info Log!");
    }
}
