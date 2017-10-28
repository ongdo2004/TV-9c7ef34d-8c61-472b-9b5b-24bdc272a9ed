package com.project

import com.project.service.ApplicationConstants
import com.project.util.ApplicationUtils
import grails.converters.JSON

class MigrationController {

    def createUser(String username) {

        String password = ApplicationUtils.encrypt(username, ApplicationConstants.ENCRYPT_SALT);

        UserProfile userProfile = new UserProfile(
                username: username, password: password, lastUpdateTime: new Date(), lastUpdateUser: "system",
                isDeleted: false,
        );

        userProfile.save(flush: true);

        render(userProfile as JSON);
    }
}
