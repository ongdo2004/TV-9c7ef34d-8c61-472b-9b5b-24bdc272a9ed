package com.project

class UserSession {

    UUID id;
    UUID userProfileId;
    Date expireDate;

    static constraints = {

        userProfileId(nullable: false);
        expireDate(nullable: false);
    }

    static mapping = {

        userProfileId(type: "uuid-char", length: 36);
    }
}
