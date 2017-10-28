package com.project.view

class UserProfileView {

    UUID id;
    String username;

    static constraints = {
    }

    static mapping = {

        version(false);
        table("v_user_profile")
    }
}
