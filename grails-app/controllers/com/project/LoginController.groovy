package com.project

import com.project.service.ResultBean
import com.project.service.login.LoginForm
import com.project.view.UserProfileView
import grails.converters.JSON

class LoginController {

    static scope = "request";

    def loginService;
    def requestService;
    def changePasswordService;
    def userProfileService;

    def login() {

        LoginForm form = bindData(new LoginForm(), this.request.JSON);

        loginService.login(form);

        render(this.loginService.resultBean as JSON);
    }

    def getUserProfile() {

        UserProfileView userProfileView = userProfileService.getUserProfileView(this.requestService.userProfile.id);

        render(new ResultBean(isSuccess: true, result: userProfileView) as JSON);
    }

    def changePassword() {

        def ChangePasswordForm form = bindData(new ChangePasswordForm(), this.request.JSON);

        changePasswordService.changePassword(form);

        render(changePasswordService.resultBean as JSON);
    }
}
