import java.util.regex.Pattern;

/**
 * PasswordValidator.java
 *
 * Validates password strength according to security rules.
 */
public class PasswordValidator {

    /**
     * Validates a password.
     *
     * Rules:
     * - Minimum 8 characters
     * - At least one uppercase letter
     * - At least one lowercase letter
     * - At least one digit
     * - At least one special character
     * - No spaces
     *
     * @param password Password entered by the user
     * @return true if password is valid
     */
    public static boolean validate(String password) {

        if (password == null) {
            return false;
        }

        if (password.length() < Constants.MIN_PASSWORD_LENGTH) {
            return false;
        }

        if (password.contains(" ")) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            }
            else if (Character.isLowerCase(ch)) {
                hasLower = true;
            }
            else if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            else {
                hasSpecial = true;
            }

        }

        return hasUpper && hasLower && hasDigit && hasSpecial;

    }

    /**
     * Checks if password contains uppercase letters.
     *
     * @param password Password
     * @return true if uppercase exists
     */
    public static boolean hasUpperCase(String password) {

        for (char ch : password.toCharArray()) {

            if (Character.isUpperCase(ch)) {
                return true;
            }

        }

        return false;

    }

    /**
     * Checks if password contains lowercase letters.
     *
     * @param password Password
     * @return true if lowercase exists
     */
    public static boolean hasLowerCase(String password) {

        for (char ch : password.toCharArray()) {

            if (Character.isLowerCase(ch)) {
                return true;
            }

        }

        return false;

    }

    /**
     * Checks if password contains digits.
     *
     * @param password Password
     * @return true if digit exists
     */
    public static boolean hasDigit(String password) {

        for (char ch : password.toCharArray()) {

            if (Character.isDigit(ch)) {
                return true;
            }

        }

        return false;

    }

    /**
     * Checks if password contains special characters.
     *
     * @param password Password
     * @return true if special character exists
     */
    public static boolean hasSpecialCharacter(String password) {

        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");

        return pattern.matcher(password).find();

    }

    /**
     * Displays password rules.
     */
    public static void displayRules() {

        System.out.println("\n=========== PASSWORD RULES ===========");

        System.out.println("1. Minimum 8 characters");

        System.out.println("2. At least one uppercase letter");

        System.out.println("3. At least one lowercase letter");

        System.out.println("4. At least one digit");

        System.out.println("5. At least one special character");

        System.out.println("6. No spaces");

        System.out.println("======================================");

    }

    /**
     * Displays password strength.
     *
     * @param password Password
     */
    public static void displayStrength(String password) {

        int score = 0;

        if (password.length() >= Constants.MIN_PASSWORD_LENGTH)
            score++;

        if (hasUpperCase(password))
            score++;

        if (hasLowerCase(password))
            score++;

        if (hasDigit(password))
            score++;

        if (hasSpecialCharacter(password))
            score++;

        System.out.println();

        switch (score) {

            case 5:
                System.out.println("Password Strength : VERY STRONG");
                break;

            case 4:
                System.out.println("Password Strength : STRONG");
                break;

            case 3:
                System.out.println("Password Strength : MEDIUM");
                break;

            case 2:
                System.out.println("Password Strength : WEAK");
                break;

            default:
                System.out.println("Password Strength : VERY WEAK");

        }

    }

}
