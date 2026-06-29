import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * EncryptionService.java
 *
 * Provides AES encryption and decryption services.
 */
public class EncryptionService {

    /**
     * Secret AES Key
     */
    private SecretKey secretKey;

    /**
     * Constructor
     * Generates a 128-bit AES key.
     */
    public EncryptionService() {

        try {

            KeyGenerator generator =
                    KeyGenerator.getInstance(Constants.ALGORITHM);

            generator.init(128, new SecureRandom());

            secretKey = generator.generateKey();

        }

        catch (Exception exception) {

            System.out.println("Error generating encryption key.");

        }

    }

    /**
     * Encrypts plain text.
     *
     * @param plainText Original Text
     * @return Encrypted String
     */
    public String encrypt(String plainText) {

        try {

            Cipher cipher =
                    Cipher.getInstance(Constants.CIPHER);

            cipher.init(
                    Cipher.ENCRYPT_MODE,
                    secretKey
            );

            byte[] encryptedBytes =
                    cipher.doFinal(
                            plainText.getBytes()
                    );

            return Base64
                    .getEncoder()
                    .encodeToString(encryptedBytes);

        }

        catch (Exception exception) {

            System.out.println("Encryption Failed.");

            return null;

        }

    }

    /**
     * Decrypts encrypted text.
     *
     * @param encryptedText Encrypted Text
     * @return Original Text
     */
    public String decrypt(String encryptedText) {

        try {

            Cipher cipher =
                    Cipher.getInstance(Constants.CIPHER);

            cipher.init(
                    Cipher.DECRYPT_MODE,
                    secretKey
            );

            byte[] decodedBytes =
                    Base64
                            .getDecoder()
                            .decode(encryptedText);

            byte[] decryptedBytes =
                    cipher.doFinal(decodedBytes);

            return new String(decryptedBytes);

        }

        catch (Exception exception) {

            System.out.println("Decryption Failed.");

            return null;

        }

    }

    /**
     * Displays generated AES key.
     */
    public void displaySecretKey() {

        String key =
                Base64
                        .getEncoder()
                        .encodeToString(
                                secretKey.getEncoded()
                        );

        System.out.println("\nAES Secret Key");

        System.out.println("-------------------------");

        System.out.println(key);

    }

    /**
     * Encrypts and displays the output.
     *
     * @param plainText Original Text
     */
    public void demonstrateEncryption(String plainText) {

        String encrypted =
                encrypt(plainText);

        String decrypted =
                decrypt(encrypted);

        System.out.println();

        System.out.println("Original Text");

        System.out.println("----------------");

        System.out.println(plainText);

        System.out.println();

        System.out.println("Encrypted Text");

        System.out.println("----------------");

        System.out.println(encrypted);

        System.out.println();

        System.out.println("Decrypted Text");

        System.out.println("----------------");

        System.out.println(decrypted);

    }

}
