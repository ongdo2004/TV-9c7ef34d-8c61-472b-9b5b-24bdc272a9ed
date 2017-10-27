package com.project.service

import com.project.UserProfile
import grails.transaction.Transactional

@Transactional
class RequestService {

    static scope = "request";

    def UserProfile userProfile;
    def Date nowDate;
}
