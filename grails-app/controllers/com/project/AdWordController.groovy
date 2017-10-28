package com.project

import grails.converters.JSON

class AdWordController {

    static scope = "request";

    def addAdWordService;
    def updateAdWordService;
    def importAdWordService;
    def deleteAdWordService;

    def getAdWords(def criteriaList) {}

    def create() {

        AdWordForm form = bindData(new AdWordForm(), this.request.JSON);

        addAdWordService.add(form);

        render(this.addAdWordService.resultBean as JSON);
    }

    def importList() {

        List<AdWordForm> adWordForms = request.JSON.collect { bindData(new AdWordForm(), it) };

        importAdWordService.importList(adWordForms);

        render(this.importAdWordService.resultBean as JSON);
    }

    def update() {

        AdWordForm form = bindData(new AdWordForm(), this.request.JSON);

        updateAdWordService.update(form);

        render(this.updateAdWordService.resultBean as JSON);
    }

    def delete(String adWordId) {

        deleteAdWordService.delete(adWordId);

        render(this.deleteAdWordService.resultBean as JSON);
    }
}
