package africa.semicolon.gemstube.models;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {
    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // Convert the byte array to a hexadecimal representation
            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception or rethrow as needed
            throw new RuntimeException("Error hashing password", e);
        }
    }
    public static void main(String[] args) {
        String plainPassword = "password";
        String hashed1Password = hashPassword(plainPassword);
        String hashed2Password = hashPassword(plainPassword);

        System.out.println("Plain Password: " + plainPassword);
        System.out.println("Hashed Password: " + hashed1Password);


        if (hashed1Password.equals(hashed2Password))
            System.out.println("they are the same");
    }
}
