package com.project

import com.project.domain.BaseDomain

class Order implements BaseDomain {

    UUID productId;
    Long quantity;
    String code;

    String customerName;
    String customerPhone;
    String customerEmail;
    String customerAddress;

    String status;

    static constraints = {
    }
}
