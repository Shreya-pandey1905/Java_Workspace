package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class PasswordUtil {
    private static final String SALT="jdbc";

    public static String hash(String password){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashed = messageDigest.digest((SALT+password).getBytes(StandardCharsets.UTF_8));
            StringBuilder builder = new StringBuilder();
            for(byte value:hashed){
                builder.append(String.format("%02x",value));
               }
            return builder.toString();

        }catch (NoSuchAlgorithmException exception){
            throw new IllegalStateException("SHA-256 not available Exception",exception);
        }
    }
}
