package config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Utility class to hash and verify passwords using SHA-256 + Base64.
 */
public class PasswordHasher {
    
    /**
     * Hashes a plain text password using SHA-256 and encodes it with Base64.
     * 
     * @param password The plain password to hash.
     * @return The hashed and encoded password string.
     * @throws NoSuchAlgorithmException If SHA-256 is not available.
     */
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes);
    }

    /**
     * Compares a plain text password with a hashed one.
     * 
     * @param newPassword The new plain text password to check.
     * @param oldHashedPassword The old hashed password stored in the database.
     * @return true if the hashed new password matches the stored one; false otherwise.
     */
    public static boolean checkPassword(String newPassword, String oldHashedPassword) {
        try {
            String newHashedPassword = hashPassword(newPassword);
            return newHashedPassword.equals(oldHashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
}
