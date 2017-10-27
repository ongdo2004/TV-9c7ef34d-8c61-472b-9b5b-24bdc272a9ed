package com.project

import com.project.domain.BaseDomain

class UserProfile implements BaseDomain {

    String username;
    String password;

    static constraints = {

        username(nullable: false, size: 0..20);
        password(nullable: false, size: 0..200);
    }

    static mapping = {

        username(type: "string", length: 20);
        password(type: "string", length: 200);
    }
}
