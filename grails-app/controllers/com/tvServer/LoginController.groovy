package com.tvServer

import com.project.service.ResultBean
import com.project.service.login.LoginForm
import grails.converters.JSON

class LoginController {

    static scope = "request";

    def loginService;
    def requestService;

    def login() {

        def LoginForm form = bindData(new LoginForm(), this.request.JSON);

        loginService.login(form);

        render(this.loginService.resultBean as JSON);
    }

    def getUserProfile() {

        render(new ResultBean(isSuccess: true, result: this.requestService.userProfile) as JSON);
    }
}