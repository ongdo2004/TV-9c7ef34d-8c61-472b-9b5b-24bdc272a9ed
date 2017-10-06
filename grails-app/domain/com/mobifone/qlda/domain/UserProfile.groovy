package com.mobifone.qlda.domain

class UserProfile implements BaseDomain {

    String email;
    String username;
    String password;
    Boolean isAdmin = false;

    Date expireDate;
    UUID productId;

    static constraints = {
    }
}
