package com.mobifone.qlda.service.login

import grails.validation.Validateable

@Validateable
class LoginForm {

    def String username;
    def String password;

    static constraints = {

        username nullable: false, blank: false;
        password nullable: false, blank: false;
    }
}
