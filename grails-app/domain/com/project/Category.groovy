package com.project

import com.project.domain.BaseDomain

class Category implements BaseDomain {

    String code;
    String title;
    UUID parentCategoryId;

    static constraints = {

        code(nullable: false, size: 0..50);
        title(nullable: false, size: 0..200);

        parentCategoryId(nullable: true);
    }

    static mapping = {

        parentCategoryId(type: "uuid-char", length: 36);
        code(type: "string", length: 50);
        title(type: "string", length: 200);
    }
}
