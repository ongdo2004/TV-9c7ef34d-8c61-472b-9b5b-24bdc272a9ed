package com.tvServer


import com.mobifone.qlda.service.BaseService
import com.mobifone.qlda.service.ws.RenewCmd
import com.mobifone.qlda.service.ws.sendOwl.Order
import grails.transaction.Transactional

@Transactional
class RenewService extends BaseService {

    static scope = "request"

    private Order order;

    private UserProfile getUserProfile(String buyerEmail, String sendOwlProductId) {

        def Product product = Product.findBySendOwlProductId(sendOwlProductId);

        return UserProfile.findByEmailAndProductId(buyerEmail, product?.id);
    }

    def Boolean renewAccount(Order order) {

        this.order = order;

        RenewCmd renewCmd = new RenewCmd();

        renewCmd.userProfile = this.getUserProfile(order.buyerEmail, order.sendOwlProductId);

        renewCmd.execute();
    }
}
