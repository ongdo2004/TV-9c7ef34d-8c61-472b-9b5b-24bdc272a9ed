package com.project.filters

import com.project.UserProfile
import com.project.service.ApplicationConstants
import com.project.service.RequestService

class AuthenticateFilters {

    def userProfileService;

    def filters = {

        all(controller: '*', action: '*') {

            before = {

                def requestService = applicationContext.requestService;

                Date now = requestService.nowDate = new Date();

                println ((controllerName == "migration") || (controllerName == "login" && actionName == "login"));

                if ((controllerName == "migration") || (controllerName == "login" && actionName == "login")) {

                } else {

                    String userToken = params.get(ApplicationConstants.USER_TOKEN);

                    println userToken;

                    UserProfile userProfile = userProfileService.getUserProfile(userToken, now);

                    applicationContext.requestService.userProfile = userProfile;
                }
            }

            after = { Map model ->

            }

            afterView = { Exception e ->

            }
        }
    }
}
