package com.mobifone.qlda.service.criteria

import com.mobifone.qlda.common.Error
import com.mobifone.qlda.domain.Criteria
import com.mobifone.qlda.service.BaseService
import com.mobifone.qlda.service.CriteriaForm
import grails.transaction.Transactional

@Transactional
class CriteriaAddService extends BaseService {

    static scope = "request";

    def requestService;

    private CriteriaForm form;
    private Criteria criteria;

    private Boolean validateForm() {

        if (!this.form.validate()) {

            this.errors = Error.convert(this.form.errors);

            return false;
        }

        return true;
    }

    private Boolean validate() {

        Boolean validateResult = this.validateForm();

        if (!validateResult) return false;

        return true;
    }

    private void saveCriteria() {

        this.criteria = new Criteria(
                name: form.name, description: form.description, type: form.type,
                lastUpdateTime: requestService.nowDate, lastUpdateUser: "admin"
        );

        this.criteria.save(flush: true, failOnError: true);
    }

    Boolean create(CriteriaForm form) {

        this.form = form;

        if (!this.validate()) return false;

        this.saveCriteria();

        this.result.criteria = this.criteria;

        return true;
    }
}
