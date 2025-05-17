package framework.logging;

import framework.browserCofig.TestInit;
public class LogManagement {
    public static void logMessage(String level, String message) {
        switch (level) {
            case "INFO":
                TestInit.logger.trace(message);
                break;
            case "DEBUG":
                TestInit.logger.debug(message);
                break;
            case "ERROR":
                TestInit.logger.error(message);
                break;
            case "WARN":
                TestInit.logger.warn(message);
                break;
            case "FATAL":
                TestInit.logger.fatal(message);
                break;
            default:
                TestInit.logger.info(message);
        }
    }
}