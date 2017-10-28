package com.project.service

import com.project.ChangePasswordForm
import com.project.UserProfile
import com.project.common.Error
import com.project.util.ApplicationUtils
import grails.transaction.Transactional

@Transactional
class ChangePasswordService extends BaseService {

    static scope = "request";

    def requestService;

    private ChangePasswordForm form;

    private Boolean validateForm() {

        if (!this.form.validate()) {

            this.errors = Error.convert(this.form.errors);

            return false;
        }

        if (form.newPassword != form.confirmPassword) {

            this.errors << new Error(errorCode: "changePassword.confirmMissMatch");

            return false;
        }

        return true;
    }

    private Boolean validateOldPassword() {

        String oldPassword = ApplicationUtils.encrypt(form.oldPassword);

        if (oldPassword != requestService.userProfile.password) {

            this.errors << new Error(errorCode: "changePassword.oldPasswordMissMatch");

            return false;
        }

        return true;
    }

    private Boolean validate() {

        Boolean validateResult = this.validateForm() && this.validateOldPassword();

        if (!validateResult) return false;

        return true;
    }

    Boolean changePassword(ChangePasswordForm form) {

        this.form = form;

        if (!this.validate()) return false;

        UserProfile userProfile = UserProfile.get(requestService.userProfile.id);

        userProfile.with {

            password = ApplicationUtils.encrypt(form.newPassword);

            save(flush: true);
        }

        return true;
    }
}
