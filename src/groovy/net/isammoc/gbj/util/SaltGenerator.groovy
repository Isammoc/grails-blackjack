package net.isammoc.gbj.util

import java.security.SecureRandom

class SaltGenerator {

    public static final String generateSalt() {
        def salt = new byte[48]
        new SecureRandom().nextBytes(salt)
        return salt.encodeAsBase64()
    }
}