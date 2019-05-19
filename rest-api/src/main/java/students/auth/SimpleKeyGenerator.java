package students.auth;


import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class SimpleKeyGenerator implements KeyGenerator {

    @Override
    public Key generateKey() {
        String keyString = "xDDDDDDDDDDDDDDDDDDDdjasmalgosiababajaga";
        return new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "HMACSHA256");
    }
}