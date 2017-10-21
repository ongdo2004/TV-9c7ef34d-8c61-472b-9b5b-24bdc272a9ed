package com.mobifone.qlda.filters


import com.mobifone.qlda.service.ApplicationConstants

class AuthenticateFilters {

    def userProfileService;

    def filters = {

        all(controller: '*', action: '*') {

            before = {

                if (controllerName == "login" && actionName == "login") {

                } else {

                    String userToken = params.get(ApplicationConstants.USER_TOKEN);

                    UserProfile userProfile = userProfileService.getUserProfile(userToken);

                    applicationContext.requestService.userProfile = userProfile;
                    applicationContext.requestService.nowDate = new Date();
                }
            }

            after = { Map model ->

            }

            afterView = { Exception e ->

            }
        }
    }
}
