package com.project.service

import com.project.common.Error

class BaseService {

    Map result = [:];

    List<Error> errors = [];

    ResultBean getResultBean() {

        return new ResultBean(isSuccess: !this.errors, errors: this.errors, result: this.result);
    }
}
