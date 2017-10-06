package com.tvServer

import com.mobifone.qlda.service.ws.sendOwl.Order

class RenewController {

    static scope = "request";

    def renewService;

    private Order parseOrderFromRequest() {

        return null;
    }

    def renew() {

        Order order = this.parseOrderFromRequest();

        renewService.renewAccount(order);
    }
}
