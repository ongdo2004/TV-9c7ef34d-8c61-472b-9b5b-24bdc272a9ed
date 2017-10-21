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
    }
}
