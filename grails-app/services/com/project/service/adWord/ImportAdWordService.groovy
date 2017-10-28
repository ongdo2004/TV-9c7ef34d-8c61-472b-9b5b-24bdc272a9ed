package com.project.service.adWord

import com.project.AdWordForm
import com.project.adword.AdWordInfo
import com.project.common.Error
import com.project.service.BaseService
import grails.transaction.Transactional

@Transactional
class ImportAdWordService extends BaseService {

    static scope = "request";

    def requestService;

    private List<AdWordForm> forms;

    private List<AdWordInfo> adWordInfos;

    private Boolean validateForms() {

        Boolean isOK = true;

        forms.each { AdWordForm form ->

            if (!form.validate()) {

                this.errors << Error.convert(form.errors);

                isOK = false;
            }
        }

        return isOK;
    }

    private Boolean validate() {

        Boolean validateResult = this.validateForms();

        if (!validateResult) return false;

        return true;
    }

    private void saveData() {

        adWordInfos = forms.collect { AdWordForm form ->

            AdWordInfo adWordInfo = new AdWordInfo(
                    url: form.url, type: form.type, redirectURL: form.redirectURL,
                    lastUpdateTime: requestService.nowDate, lastUpdateUser: requestService.username, isDeleted: false
            );

            adWordInfo.save(flush: true);
        }
    }

    Boolean importList(List<AdWordForm> forms) {

        this.forms = forms;

        if (!this.validate()) return false;

        this.saveData();

        this.result = this.adWordInfos;

        return true;
    }
}
