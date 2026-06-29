/**
 * Constants.java
 *
 * Stores all application constants.
 * This removes magic strings and numbers from the project.
 */

public final class Constants {

    private Constants() {

    }

    /*=========================
            USER ROLES
    =========================*/

    public static final String ADMIN = "ADMIN";

    public static final String USER = "USER";



    /*=========================
          ENCRYPTION
    =========================*/

    public static final String ALGORITHM = "AES";

    public static final String CIPHER = "AES";



    /*=========================
        PASSWORD SETTINGS
    =========================*/

    public static final int MIN_PASSWORD_LENGTH = 8;



    /*=========================
          LOGGER
    =========================*/

    public static final String LOGGER_NAME =
            "CloudSecurityLogger";

    public static final String LOG_FILE =
            "security.log";



    /*=========================
          MESSAGES
    =========================*/

    public static final String LOGIN_SUCCESS =
            "Login Successful";

    public static final String LOGIN_FAILED =
            "Login Failed";

    public static final String ACCESS_GRANTED =
            "Access Granted";

    public static final String ACCESS_DENIED =
            "Access Denied";

}
