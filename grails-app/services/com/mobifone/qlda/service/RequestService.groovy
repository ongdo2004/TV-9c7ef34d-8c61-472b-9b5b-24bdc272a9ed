package com.mobifone.qlda.service


import grails.transaction.Transactional

@Transactional
class RequestService {

    static scope = "request";

    def UserProfile userProfile;
    def Date nowDate;
}
