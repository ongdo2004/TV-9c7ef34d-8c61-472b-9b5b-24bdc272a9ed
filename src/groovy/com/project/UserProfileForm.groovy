package com.project

import grails.validation.Validateable

@Validateable
class UserProfileForm {

    String oldPassword;
    String newPassword;

    static constraints = {

        oldPassword nullable: false, blank: false;
        newPassword nullable: false, blank: false;
    }
}
