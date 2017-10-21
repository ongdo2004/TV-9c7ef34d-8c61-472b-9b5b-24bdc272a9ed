package com.project.service

import com.project.common.Error
import com.project.service.login.LoginForm
import com.project.util.ApplicationUtils
import grails.transaction.Transactional

@Transactional
class LoginService extends BaseService {

    static scope = "request";


    private LoginForm form;

    private Boolean validateForm() {

        if (!this.form.validate()) {

            this.errors = Error.convert(this.form.errors);

            return false;
        }

        return true;
    }

    private Boolean validate() {

        Boolean validateResult = this.validateForm();

        if (!validateResult) return false;

        return true;
    }

    Boolean login(LoginForm form) {

        this.form = form;

        if (!this.validate()) return false;

        this.result.userProfile = UserProfileService.USER_PROFILE_DUMMY;

        this.result.token = ApplicationUtils.generateUUID();

        return true;
    }
}
