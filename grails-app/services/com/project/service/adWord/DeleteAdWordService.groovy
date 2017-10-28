package com.project.service.adWord

import com.project.AdWordForm
import com.project.adword.AdWordInfo
import com.project.common.Error
import com.project.service.BaseService
import com.project.util.ApplicationUtils
import grails.transaction.Transactional

@Transactional
class DeleteAdWordService extends BaseService {

    static scope = "request";

    def requestService;
    def adWordService;

    private AdWordInfo adWordInfo;

    private AdWordForm form;

    private Boolean validate() {

        if (!this.adWordInfo) {

            errors << new Error(errorCode: "adWord.adWordNotFound");

            return false;
        }

        return true;
    }

    private void saveData() {

        adWordInfo.with {

            lastUpdateTime = requestService.nowDate;
            lastUpdateUser = requestService.username;
            isDeleted = true;
        }

        adWordInfo.save(flush: true);
    }

    Boolean delete(String id) {

        adWordInfo = adWordService.getById(ApplicationUtils.convertToUUID(id));

        if (!this.validate()) return false;

        this.saveData();

        this.result = this.adWordInfo;

        return true;
    }
}
