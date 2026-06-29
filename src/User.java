/**
 * User.java
 *
 * Represents a user in the Cloud Security System.
 * Demonstrates encapsulation using private fields
 * with public getters and setters.
 */

public class User {

    /*=========================
            ATTRIBUTES
    =========================*/

    private String username;
    private String password;
    private String role;

    /*=========================
          CONSTRUCTORS
    =========================*/

    /**
     * Default Constructor
     */
    public User() {

    }

    /**
     * Parameterized Constructor
     *
     * @param username User Name
     * @param password User Password
     * @param role User Role
     */
    public User(String username,
                String password,
                String role) {

        this.username = username;
        this.password = password;
        this.role = role;

    }

    /*=========================
             GETTERS
    =========================*/

    /**
     * Returns Username
     *
     * @return username
     */
    public String getUsername() {

        return username;

    }

    /**
     * Returns Password
     *
     * @return password
     */
    public String getPassword() {

        return password;

    }

    /**
     * Returns Role
     *
     * @return role
     */
    public String getRole() {

        return role;

    }

    /*=========================
             SETTERS
    =========================*/

    /**
     * Sets Username
     *
     * @param username Username
     */
    public void setUsername(String username) {

        this.username = username;

    }

    /**
     * Sets Password
     *
     * @param password Password
     */
    public void setPassword(String password) {

        this.password = password;

    }

    /**
     * Sets Role
     *
     * @param role User Role
     */
    public void setRole(String role) {

        this.role = role;

    }

    /*=========================
          DISPLAY USER
    =========================*/

    @Override
    public String toString() {

        return "\nUser Information"
                + "\n-------------------------"
                + "\nUsername : " + username
                + "\nRole     : " + role;

    }

}
