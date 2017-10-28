package com.project.service

import com.project.UserProfile
import grails.transaction.Transactional

@Transactional
class RequestService {

    static scope = "request";

    UserProfile userProfile;

    Date nowDate;

    String getUsername() {
        return this.userProfile?.username;
    }
}
