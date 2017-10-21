package com.tvServer


import com.mobifone.qlda.service.BaseService
import com.mobifone.qlda.service.user.RegisterForm
import com.mobifone.qlda.service.ws.RegisterCmd
import com.mobifone.qlda.service.ws.iptv.RegisterResult
import grails.transaction.Transactional

@Transactional
class RegisterService extends BaseService {

    def productService;
    def requestService;

    private Date getExpireDate(Date requestDate, Product product) {

        return null;
    }

    private void sendActiveEmail() {
    }

    private RegisterResult sendRegisterRequestToIptv() {

        RegisterCmd registerCmd = new RegisterCmd();

        registerCmd.execute();

        RegisterResult registerResult = (RegisterResult) registerCmd.result;

        return registerResult;
    }

    private UserProfile registerUserProfile(RegisterForm form, registerResult) {

        Product product = productService.getDefaultProduct();

        UserProfile userProfile = new UserProfile(

                email: form.email, expireDate: this.getExpireDate(this.requestService.nowDate, product),
                productId: product.id
        );

        userProfile.with {

            username = registerResult.username;
            password = registerResult.password;
        };

        return userProfile;
    }

    def Boolean register(RegisterForm form) {

        RegisterResult registerResult = sendRegisterRequestToIptv();

        UserProfile userProfile = registerUserProfile(form, registerResult);

        userProfile.save(flush: true, failOnError: true);

        this.sendActiveEmail();

        return true;
    }

}
