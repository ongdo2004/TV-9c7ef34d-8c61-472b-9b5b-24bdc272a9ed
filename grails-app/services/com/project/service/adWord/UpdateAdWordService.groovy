package com.project.service.adWord

import com.project.AdWordForm
import com.project.adword.AdWordInfo
import com.project.common.Error
import com.project.service.BaseService
import com.project.util.ApplicationUtils
import grails.transaction.Transactional

@Transactional
class UpdateAdWordService extends BaseService {

    static scope = "request";

    def requestService;
    def adWordService;

    private AdWordInfo adWordInfo;

    private AdWordForm form;

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

    private void saveData() {

        adWordInfo = adWordService.getById(ApplicationUtils.convertToUUID(form.id));

        adWordInfo.with {

            url = form.url;
            type = form.type;
            redirectURL = form.redirectURL;

            lastUpdateTime = requestService.nowDate;
            lastUpdateUser = requestService.username;
            isDeleted = false;
        }

        adWordInfo.save(flush: true);
    }

    Boolean update(AdWordForm form) {

        this.form = form;

        if (!this.validate()) return false;

        this.saveData();

        this.result = this.adWordInfo;

        return true;
    }
}
