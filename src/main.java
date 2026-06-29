import java.util.Scanner;

/**
 * Main.java
 *
 * Entry point of the Cloud Security System.
 * Demonstrates:
 * - Registration
 * - Authentication
 * - Password Validation
 * - AES Encryption
 * - Role Based Access Control
 * - Security Logging
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final UserManager userManager =
            new UserManager();

    private static final EncryptionService encryptionService =
            new EncryptionService();

    private static final AccessControl accessControl =
            new AccessControl();

    private static final SecurityLogger securityLogger =
            new SecurityLogger();

    /**
     * Loads default users.
     */
    private static void initializeSystem() {

        userManager.loadDefaultUsers();

    }

    /**
     * Displays main menu.
     */
    private static void displayMainMenu() {

        System.out.println("\n====================================");

        System.out.println(" CLOUD SECURITY SYSTEM ");

        System.out.println("====================================");

        System.out.println("1. Register User");

        System.out.println("2. Login");

        System.out.println("3. View Users");

        System.out.println("4. Exit");

        System.out.print("\nEnter Choice : ");

    }

    /**
     * Register a new user.
     */
    private static void registerUser() {

        PasswordValidator.displayRules();

        System.out.print("\nUsername : ");

        String username =
                scanner.nextLine();

        if(userManager.userExists(username)){

            System.out.println("\nUser already exists.");

            return;

        }

        System.out.print("Password : ");

        String password =
                scanner.nextLine();

        if(!PasswordValidator.validate(password)){

            System.out.println("\nWeak Password.");

            PasswordValidator.displayStrength(password);

            return;

        }

        PasswordValidator.displayStrength(password);

        System.out.print("Role (ADMIN/USER): ");

        String role =
                scanner.nextLine().toUpperCase();

        if(!role.equals(Constants.ADMIN)
                &&
                !role.equals(Constants.USER)){

            System.out.println("Invalid Role.");

            return;

        }

        boolean success =
                userManager.registerUser(
                        username,
                        password,
                        role
                );

        if(success){

            System.out.println(
                    "\nRegistration Successful."
            );

            securityLogger.logRegistration(
                    username
            );

        }

        else{

            System.out.println(
                    "\nRegistration Failed."
            );

        }

    }

    /**
     * Login User.
     */
    private static User loginUser(){

        System.out.print("\nUsername : ");

        String username =
                scanner.nextLine();

        System.out.print("Password : ");

        String password =
                scanner.nextLine();

        User user =
                userManager.authenticate(
                        username,
                        password
                );

        if(user==null){

            System.out.println(
                    "\nInvalid Credentials."
            );

            securityLogger.logLoginFailure(
                    username
            );

            return null;

        }

        securityLogger.logLoginSuccess(
                username
        );

        System.out.println(
                "\nLogin Successful."
        );

        return user;

    }

    /**
     * Encrypt and Decrypt Demo.
     */
    private static void encryptionMenu(User user){

        if(!accessControl.canEncrypt(user)){

            accessControl.printAccessStatus(false);

            securityLogger.logUnauthorizedAccess(
                    user.getUsername()
            );

            return;

        }

        System.out.print(
                "\nEnter Plain Text : "
        );

        String text =
                scanner.nextLine();

        String encrypted =
                encryptionService.encrypt(text);

        System.out.println(
                "\nEncrypted Text"
        );

        System.out.println(
                encrypted
        );

        securityLogger.logEncryption(
                user.getUsername()
        );

        String decrypted =
                encryptionService.decrypt(
                        encrypted
                );

        System.out.println(
                "\nDecrypted Text"
        );

        System.out.println(
                decrypted
        );

        securityLogger.logDecryption(
                user.getUsername()
        );

    }
      /**
     * Change password for the logged-in user.
     */
    private static void changePassword(User user) {

        if (!accessControl.canChangePassword(user)) {

            accessControl.printAccessStatus(false);

            return;

        }

        System.out.print("\nEnter Current Password : ");

        String currentPassword = scanner.nextLine();

        if (!user.getPassword().equals(currentPassword)) {

            System.out.println("Incorrect Current Password.");

            return;

        }

        System.out.print("Enter New Password : ");

        String newPassword = scanner.nextLine();

        if (!PasswordValidator.validate(newPassword)) {

            System.out.println("Weak Password.");

            PasswordValidator.displayStrength(newPassword);

            return;

        }

        userManager.changePassword(
                user.getUsername(),
                newPassword
        );

        securityLogger.logPasswordChange(
                user.getUsername()
        );

        System.out.println("\nPassword Updated Successfully.");

    }

    /**
     * Displays all registered users.
     */
    private static void displayUsers(User user) {

        if (!accessControl.canViewUsers(user)) {

            accessControl.printAccessStatus(false);

            securityLogger.logUnauthorizedAccess(
                    user.getUsername()
            );

            return;

        }

        userManager.displayUsers();

    }

    /**
     * Deletes a user.
     */
    private static void deleteUser(User user) {

        if (!accessControl.canDeleteUsers(user)) {

            accessControl.printAccessStatus(false);

            securityLogger.logUnauthorizedAccess(
                    user.getUsername()
            );

            return;

        }

        System.out.print("\nEnter Username to Delete : ");

        String username = scanner.nextLine();

        if (username.equalsIgnoreCase(user.getUsername())) {

            System.out.println("You cannot delete your own account.");

            return;

        }

        boolean deleted =
                userManager.removeUser(username);

        if (deleted) {

            System.out.println("User Deleted Successfully.");

            securityLogger.logUserDeletion(username);

        }

        else {

            System.out.println("User Not Found.");

        }

    }

    /**
     * Admin menu.
     */
    private static void adminMenu(User user) {

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println("           ADMIN MENU");
            System.out.println("====================================");
            System.out.println("1. View Users");
            System.out.println("2. Register User");
            System.out.println("3. Delete User");
            System.out.println("4. Encrypt Data");
            System.out.println("5. Change Password");
            System.out.println("6. Logout");

            System.out.print("\nEnter Choice : ");

            try {

                choice =
                        Integer.parseInt(scanner.nextLine());

            }

            catch (NumberFormatException exception) {

                System.out.println("Invalid Input.");

                choice = 0;

            }

            switch (choice) {

                case 1:

                    displayUsers(user);

                    break;

                case 2:

                    registerUser();

                    break;

                case 3:

                    deleteUser(user);

                    break;

                case 4:

                    encryptionMenu(user);

                    break;

                case 5:

                    changePassword(user);

                    break;

                case 6:

                    securityLogger.logLogout(
                            user.getUsername()
                    );

                    System.out.println("Logging Out...");

                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        } while (choice != 6);

    }

    /**
     * User menu.
     */
    private static void userMenu(User user) {

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println("            USER MENU");
            System.out.println("====================================");
            System.out.println("1. Encrypt Data");
            System.out.println("2. Change Password");
            System.out.println("3. Logout");

            System.out.print("\nEnter Choice : ");

            try {

                choice =
                        Integer.parseInt(scanner.nextLine());

            }

            catch (NumberFormatException exception) {

                System.out.println("Invalid Input.");

                choice = 0;

            }

            switch (choice) {

                case 1:

                    encryptionMenu(user);

                    break;

                case 2:

                    changePassword(user);

                    break;

                case 3:

                    securityLogger.logLogout(
                            user.getUsername()
                    );

                    System.out.println("Logging Out...");

                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        } while (choice != 3);

    }
      /**
     * Main Method
     */
    public static void main(String[] args) {

        initializeSystem();

        System.out.println("========================================");
        System.out.println("      CLOUD SECURITY SYSTEM");
        System.out.println("========================================");

        boolean running = true;

        while (running) {

            displayMainMenu();

            int choice;

            try {

                choice = Integer.parseInt(scanner.nextLine());

            }

            catch (NumberFormatException exception) {

                System.out.println("\nPlease enter a valid number.");

                continue;

            }

            switch (choice) {

                case 1:

                    registerUser();

                    break;

                case 2:

                    User loggedInUser = loginUser();

                    if (loggedInUser != null) {

                        accessControl.displayPermissions(loggedInUser);

                        if (accessControl.isAdmin(loggedInUser)) {

                            adminMenu(loggedInUser);

                        }

                        else {

                            userMenu(loggedInUser);

                        }

                    }

                    break;

                case 3:

                    userManager.displayUsers();

                    break;

                case 4:

                    running = false;

                    System.out.println("\nThank You For Using Cloud Security System.");

                    break;

                default:

                    System.out.println("\nInvalid Choice.");

            }

        }

        scanner.close();

    }

}
