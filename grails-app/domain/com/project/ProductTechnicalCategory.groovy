package com.project

import com.project.domain.BaseDomain

class ProductTechnicalCategory implements BaseDomain {

    String code;
    UUID categoryId;
    String title;

    static constraints = {

        code(nullable: false, size: 0..50);
        title(nullable: false, size: 0..200);
        categoryId(nullable: false);
    }

    static mapping = {

        categoryId(type: "uuid-char", length: 36);
        code(type: "string", length: 50);
        title(type: "string", length: 200);
    }
}
