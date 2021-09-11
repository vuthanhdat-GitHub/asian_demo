package com.asian.backend.gateway.study;

import com.asian.backend.commons.constants.CommonConstant;
import com.asian.backend.domains.dto.StudyDTO;
import com.asian.backend.study.service.StudyService;
import com.asian.backend.utils.responseBuilder.ResponseEntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author datdv
 */
@RestController
@RequestMapping("/api/study")
public class StudyAPI {

    private final StudyService studyService;

    @Autowired
    public StudyAPI(StudyService studyService) {
        this.studyService = studyService;
    }

    @RequestMapping(value = "" , method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody StudyDTO dto) {
        return ResponseEntityBuilder.getBuilder()
                .setDetails(studyService.save(dto))
                .setMessage(CommonConstant.MESSAGE.STUDY.SAVE_SUCCESS)
                .build();
    }
}
