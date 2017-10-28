package com.project.service

import com.project.UserProfile
import com.project.UserSession
import com.project.common.Error
import com.project.service.login.LoginForm
import com.project.util.ApplicationUtils
import grails.converters.JSON
import grails.transaction.Transactional

@Transactional
class LoginService extends BaseService {

    static scope = "request";

    def requestService;

    private LoginForm form;

    private UserProfile userProfile;

    private Boolean validateForm() {

        if (!this.form.validate()) {

            this.errors = Error.convert(this.form.errors);

            return false;
        }

        return true;
    }

    private Boolean validateUsernamePassword() {

        String password = ApplicationUtils.encrypt(
                form.password, ApplicationConstants.ENCRYPT_SALT
        );

        userProfile = UserProfile.findByUsernameAndPasswordAndIsDeleted(
                form.username, password, false
        )

        if (!userProfile) {

            this.errors << new Error(errorCode: "login.invalidUsernamePassword", params: [form.username, form.password]);

            return false;
        }

        return true;
    }

    private Boolean validate() {

        Boolean validateResult = this.validateForm() && this.validateUsernamePassword();

        if (!validateResult) return false;

        return true;
    }

    private UserSession getUserSession() {

        UserSession session = UserSession.findByUserProfileIdAndExpireDateGreaterThan(
                userProfile.id, requestService.nowDate
        );

        if (!session) {

            session = new UserSession(userProfileId: userProfile.id, expireDate: requestService.nowDate + 30);

            session.save(flush: true);
        }

        return session;
    }

    Boolean login(LoginForm form) {

        this.form = form;

        if (!this.validate()) return false;

        UserSession session = this.userSession;

        this.result.token = session.id;

        return true;
    }
}
