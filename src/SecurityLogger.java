import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * SecurityLogger.java
 *
 * Handles application logging.
 * All security-related events are stored in security.log.
 */
public class SecurityLogger {

    /**
     * Logger object
     */
    private Logger logger;

    /**
     * Constructor
     */
    public SecurityLogger() {

        try {

            logger = Logger.getLogger(Constants.LOGGER_NAME);

            logger.setUseParentHandlers(false);

            FileHandler fileHandler =
                    new FileHandler(Constants.LOG_FILE, true);

            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);

        }

        catch (IOException exception) {

            System.out.println("Unable to create log file.");

        }

    }

    /**
     * Logs an information message.
     *
     * @param message Log message
     */
    public void logInfo(String message) {

        logger.log(Level.INFO, message);

    }

    /**
     * Logs a warning.
     *
     * @param message Warning message
     */
    public void logWarning(String message) {

        logger.log(Level.WARNING, message);

    }

    /**
     * Logs an error.
     *
     * @param message Error message
     */
    public void logError(String message) {

        logger.log(Level.SEVERE, message);

    }

    /**
     * Login Success
     *
     * @param username Username
     */
    public void logLoginSuccess(String username) {

        logger.info("User Logged In : " + username);

    }

    /**
     * Login Failure
     *
     * @param username Username
     */
    public void logLoginFailure(String username) {

        logger.warning("Failed Login : " + username);

    }

    /**
     * User Registration
     *
     * @param username Username
     */
    public void logRegistration(String username) {

        logger.info("New User Registered : " + username);

    }

    /**
     * Password Change
     *
     * @param username Username
     */
    public void logPasswordChange(String username) {

        logger.info("Password Changed : " + username);

    }

    /**
     * Encryption Event
     *
     * @param username Username
     */
    public void logEncryption(String username) {

        logger.info("Encryption Performed By : " + username);

    }

    /**
     * Decryption Event
     *
     * @param username Username
     */
    public void logDecryption(String username) {

        logger.info("Decryption Performed By : " + username);

    }

    /**
     * User Deletion
     *
     * @param username Username
     */
    public void logUserDeletion(String username) {

        logger.warning("User Deleted : " + username);

    }

    /**
     * Logout Event
     *
     * @param username Username
     */
    public void logLogout(String username) {

        logger.info("User Logged Out : " + username);

    }

    /**
     * Invalid Access
     *
     * @param username Username
     */
    public void logUnauthorizedAccess(String username) {

        logger.warning("Unauthorized Access Attempt : " + username);

    }

}
