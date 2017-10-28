package com.project.util

import com.project.service.ApplicationConstants

import java.security.MessageDigest

class ApplicationUtils {

    static String generateUUID() {

        return UUID.randomUUID().toString();
    }

    static UUID convertToUUID(String id) {

        return id ? UUID.fromString(id) : null;
    }

    static String encrypt(String source) {

        return encrypt(source, ApplicationConstants.ENCRYPT_SALT);
    }

    static String encrypt(String source, String salt) {

        return md5(source + (salt ?: ""));
    }

    static String md5(String str) {

        String result = "";

        MessageDigest digest;

        digest = MessageDigest.getInstance("MD5");

        digest.update(str.getBytes());

        BigInteger bigInteger = new BigInteger(1, digest.digest());

        result = bigInteger.toString(16);

        return result;
    }
}
