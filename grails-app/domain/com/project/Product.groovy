package com.project

import com.project.domain.BaseDomain

class Product implements BaseDomain {

    String name;
    String code;
    String tradeMark;
    Long price;
    Long saleOffPrice;
    String status;
    Long warrantyTime;
    String imageURL;
    String detailHtmlContent;

    Boolean isBestSelling;
    Boolean isNew;
    Boolean isSaleOff;

    static constraints = {
        name(nullable: false, size: 0..200);
        code(nullable: false, size: 0..50);
        tradeMark(nullable: true, size: 0..50);
        price(nullable: true, min: 0L);
        saleOffPrice(nullable: true, min: 0L);
        status(nullable: true, size: 0..20);
        warrantyTime(nullable: true, min: 0L);
        imageURL(nullable: true, size: 0..300);
        detailHtmlContent(nullable: true);
        isBestSelling(nullable: true);
        isNew(nullable: true);
        isSaleOff(nullable: true);
    }

    static mapping = {

        name(type: "string", length: 200);
        code(type: "string", length: 50);
        tradeMark(type: "string", length: 50);
        status(type: "string", length: 20);
        imageURL(type: "string", length: 300);
        detailHtmlContent(sqlType: "text");
    }
}
