package com.project

import grails.validation.Validateable

@Validateable
class ChangePasswordForm {

    String oldPassword;
    String newPassword;
    String confirmPassword;

    static constraints = {

        oldPassword(nullable: false, size: 0..20);
        newPassword(nullable: false, size: 0..20);
        confirmPassword(nullable: false, size: 0..20);
    }
}
