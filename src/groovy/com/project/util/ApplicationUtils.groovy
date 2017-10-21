package com.project.util

class ApplicationUtils {

    static String generateUUID() {

        return UUID.randomUUID().toString();
    }

    static String encrypt(String source, String salt) {

        return source + salt;
    }
}
