package com.tvServer

import com.mobifone.qlda.common.table.TableQueryParams

import com.mobifone.qlda.service.ResultBean
import com.mobifone.qlda.service.user.RegisterForm
import grails.converters.JSON

class UserController {

    def userProfileService;
    def requestService;
    def registerService;

    def get() {

        UserProfileView userProfileView = userProfileService.getUserProfileView(this.requestService.userProfile.id);

        render(new ResultBean(result: userProfileView) as JSON);
    }

    def getList() {

        TableQueryParams tableQueryParams = bindData(new TableQueryParams(), request.JSON);

        println tableQueryParams.properties;

        render(new ResultBean(result: userProfileService.getList(tableQueryParams)) as JSON);
    }

    def register() {

        def RegisterForm form = bindData(new RegisterForm(), this.request.JSON);

        render(new ResultBean(result: registerService.register(form)) as JSON);
    }
}
