package com.project.common

import org.springframework.validation.Errors

class Error {

    String errorCode;

    def params;

    static List<Error> convert(Errors errors) {

        return errors.fieldErrors.collect {

            return new Error(errorCode: ErrorCode.FIELD_ERROR, params: [it.field, it.code, it.arguments])
        };
    }
}
