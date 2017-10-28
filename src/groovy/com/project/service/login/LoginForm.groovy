package com.project.service.login

import grails.validation.Validateable

@Validateable
class LoginForm {

    def String username;
    def String password;

    static constraints = {

        username(nullable: false, blank: false, size: 0..20);
        password(nullable: false, blank: false, size: 0..20);
    }
}
