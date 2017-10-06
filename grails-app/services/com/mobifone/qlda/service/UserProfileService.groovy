package com.mobifone.qlda.service

import com.mobifone.qlda.service.login.UserProfile
import grails.transaction.Transactional

@Transactional
class UserProfileService {

    static final UserProfile USER_PROFILE_DUMMY = new UserProfile(
            avatar: "assets/img/user2-160x160.jpg", fullName: "Administrator", status: "available",
            occupation: "staff"
    )

    UserProfile getUserProfile(String userToken) {

        println(userToken);

        return USER_PROFILE_DUMMY;
    }
}
