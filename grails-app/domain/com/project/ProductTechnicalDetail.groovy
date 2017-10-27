package com.project

import com.project.domain.BaseDomain

class ProductTechnicalDetail implements BaseDomain {

    String code;
    String detail;

    static constraints = {

        code(nullable: false, size: 0..50);
        detail(nullable: false, size: 0..200);
    }

    static mapping = {

        code(type: "string", length: 50);
        detail(type: "string", length: 200);
    }
}
