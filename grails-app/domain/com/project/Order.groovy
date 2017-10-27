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

        productId(nullable: false);
        quantity(nullable: false, min: 1L);
        code(nullable: false, size: 0..50);
        customerName(nullable: false, size: 0..200);
        customerPhone(nullable: true, size: 0..50);
        customerEmail(nullable: true, size: 0..50, email: true);
        customerAddress(nullable: true, size: 0..500);
        status(nullable: false, size: 0..20);
    }

    static mapping = {

        table(name: "sale_order");

        productId(type: "uuid-char", length: 36);
        code(type: "string", length: 50);
        customerName(type: "string", length: 200);
        customerPhone(type: "string", length: 50);
        customerEmail(type: "string", length: 50);
        customerAddress(type: "string", length: 500);
        status(type: "string", length: 20);
    }

}
