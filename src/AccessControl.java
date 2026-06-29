/**
 * AccessControl.java
 *
 * Handles Role-Based Access Control (RBAC).
 * This class checks user permissions based on roles.
 */
public class AccessControl {

    /**
     * Checks whether the user is an Admin.
     *
     * @param user Logged-in user
     * @return true if Admin
     */
    public boolean isAdmin(User user) {

        return user != null &&
                Constants.ADMIN.equalsIgnoreCase(user.getRole());

    }

    /**
     * Checks whether the user is a Normal User.
     *
     * @param user Logged-in user
     * @return true if User
     */
    public boolean isUser(User user) {

        return user != null &&
                Constants.USER.equalsIgnoreCase(user.getRole());

    }

    /**
     * Displays available permissions.
     *
     * @param user Logged-in user
     */
    public void displayPermissions(User user) {

        if (user == null) {

            System.out.println("\nAccess Denied.");

            return;

        }

        System.out.println("\n========================================");
        System.out.println("Logged In As : " + user.getUsername());
        System.out.println("Role         : " + user.getRole());
        System.out.println("========================================");

        if (isAdmin(user)) {

            System.out.println("Permissions");

            System.out.println("---------------------------");

            System.out.println("✓ Register Users");

            System.out.println("✓ Delete Users");

            System.out.println("✓ View All Users");

            System.out.println("✓ Encrypt Data");

            System.out.println("✓ Decrypt Data");

            System.out.println("✓ Change Password");

            System.out.println("✓ View Logs");

        }

        else {

            System.out.println("Permissions");

            System.out.println("---------------------------");

            System.out.println("✓ Encrypt Data");

            System.out.println("✓ Decrypt Data");

            System.out.println("✓ Change Password");

        }

        System.out.println();

    }

    /**
     * Checks if the user can register new users.
     *
     * @param user Logged-in user
     * @return true if allowed
     */
    public boolean canRegisterUsers(User user) {

        return isAdmin(user);

    }

    /**
     * Checks if the user can delete users.
     *
     * @param user Logged-in user
     * @return true if allowed
     */
    public boolean canDeleteUsers(User user) {

        return isAdmin(user);

    }

    /**
     * Checks if the user can view all users.
     *
     * @param user Logged-in user
     * @return true if allowed
     */
    public boolean canViewUsers(User user) {

        return isAdmin(user);

    }

    /**
     * Checks if the user can encrypt data.
     *
     * @param user Logged-in user
     * @return true if allowed
     */
    public boolean canEncrypt(User user) {

        return user != null;

    }

    /**
     * Checks if the user can decrypt data.
     *
     * @param user Logged-in user
     * @return true if allowed
     */
    public boolean canDecrypt(User user) {

        return user != null;

    }

    /**
     * Checks if the user can change password.
     *
     * @param user Logged-in user
     * @return true if allowed
     */
    public boolean canChangePassword(User user) {

        return user != null;

    }

    /**
     * Displays access status.
     *
     * @param allowed Access status
     */
    public void printAccessStatus(boolean allowed) {

        if (allowed) {

            System.out.println(Constants.ACCESS_GRANTED);

        }

        else {

            System.out.println(Constants.ACCESS_DENIED);

        }

    }

}
