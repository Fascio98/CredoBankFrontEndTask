package Utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;

public class RandomStringGenerator {
    SecureRandom secureRandom = new SecureRandom();

    public String userName = RandomStringUtils.random(
            12,        // length
            0,         // start unicode (ignored if chars != null or letters/numbers true)
            0,         // end unicode
            true,      // letters
            true,      // numbers
            null,      // optional char array
            secureRandom
    );

    public String password = RandomStringUtils.random(
            8,        // length
            0,         // start unicode (ignored if chars != null or letters/numbers true)
            0,         // end unicode
            true,      // letters
            true,      // numbers
            null,      // optional char array
            secureRandom
    );
}
