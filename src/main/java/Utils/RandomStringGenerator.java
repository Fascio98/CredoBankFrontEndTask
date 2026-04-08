package Utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;

public class RandomStringGenerator {
    private static final int USERNAME_LENGTH = 12;
    private static final int PASSWORD_LENGTH = 8;
    
    private final SecureRandom secureRandom = new SecureRandom();
    
    public String generateUsername() {
        return RandomStringUtils.random(
                USERNAME_LENGTH,
                0,
                0,
                true,      // letters
                true,      // numbers
                null,
                secureRandom
        );
    }

    public String generatePassword() {
        return RandomStringUtils.random(
                PASSWORD_LENGTH,
                0,
                0,
                true,      // letters
                true,      // numbers
                null,
                secureRandom
        );
    }
}
