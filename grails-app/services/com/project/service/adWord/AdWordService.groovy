package com.project.service.adWord

import com.project.adword.AdWordInfo
import grails.transaction.Transactional

@Transactional
class AdWordService {

    def getById(UUID id) {

        return AdWordInfo.findByIdAndIsDeleted(id, false);
    }
}
