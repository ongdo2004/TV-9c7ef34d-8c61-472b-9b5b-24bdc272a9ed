package com.project

import com.project.domain.BaseDomain

class Category implements BaseDomain {

    String code;
    String title;
    UUID parentCategoryId;

    static constraints = {
    }
}
