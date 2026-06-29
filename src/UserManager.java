import java.util.Collection;
import java.util.HashMap;

/**
 * UserManager.java
 *
 * Handles all user-related operations such as:
 * - Registration
 * - Authentication
 * - Searching Users
 * - Password Updates
 * - User Removal
 */
public class UserManager {

    /**
     * Stores users using username as the key.
     */
    private final HashMap<String, User> users;

    /**
     * Constructor
     */
    public UserManager() {

        users = new HashMap<>();

    }

    /**
     * Registers a new user.
     *
     * @param username Username
     * @param password Password
     * @param role User Role
     * @return true if registration succeeds
     */
    public boolean registerUser(String username,
                                String password,
                                String role) {

        if (users.containsKey(username)) {
            return false;
        }

        User user = new User(username, password, role);

        users.put(username, user);

        return true;

    }

    /**
     * Authenticates a user.
     *
     * @param username Username
     * @param password Password
     * @return User object if credentials are valid
     */
    public User authenticate(String username,
                             String password) {

        User user = users.get(username);

        if (user == null) {
            return null;
        }

        if (user.getPassword().equals(password)) {
            return user;
        }

        return null;

    }

    /**
     * Checks whether a username already exists.
     *
     * @param username Username
     * @return true if present
     */
    public boolean userExists(String username) {

        return users.containsKey(username);

    }

    /**
     * Returns a user.
     *
     * @param username Username
     * @return User object
     */
    public User getUser(String username) {

        return users.get(username);

    }

    /**
     * Updates user password.
     *
     * @param username Username
     * @param newPassword New Password
     * @return true if successful
     */
    public boolean changePassword(String username,
                                  String newPassword) {

        User user = users.get(username);

        if (user == null) {
            return false;
        }

        user.setPassword(newPassword);

        return true;

    }

    /**
     * Removes a user.
     *
     * @param username Username
     * @return true if removed
     */
    public boolean removeUser(String username) {

        if (!users.containsKey(username)) {
            return false;
        }

        users.remove(username);

        return true;

    }

    /**
     * Returns all registered users.
     *
     * @return Collection of users
     */
    public Collection<User> getAllUsers() {

        return users.values();

    }

    /**
     * Displays all users.
     */
    public void displayUsers() {

        if (users.isEmpty()) {

            System.out.println("\nNo users registered.");

            return;

        }

        System.out.println("\n========== REGISTERED USERS ==========");

        for (User user : users.values()) {

            System.out.println(user);

            System.out.println("--------------------------------------");

        }

    }

    /**
     * Creates some default users.
     */
    public void loadDefaultUsers() {

        registerUser(
                "admin",
                "Admin@123",
                Constants.ADMIN);

        registerUser(
                "john",
                "John@123",
                Constants.USER);

        registerUser(
                "alice",
                "Alice@123",
                Constants.USER);

    }

}
