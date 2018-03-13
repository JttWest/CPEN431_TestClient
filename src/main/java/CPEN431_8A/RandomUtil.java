package CPEN431_8A;

import com.google.protobuf.ByteString;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {
    static final SecureRandom random = new SecureRandom();

    // return a randomByteString of size [minSize, maxSize]
    public static ByteString getRandomByteString(int minSize, int maxSize) {
        int randLength = ThreadLocalRandom.current().nextInt(minSize, maxSize + 1);
        byte[] randBytes = new byte[randLength];
        random.nextBytes(randBytes);

        return ByteString.copyFrom(randBytes);
    }
}
