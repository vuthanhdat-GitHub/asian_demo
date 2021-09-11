package com.asian.backend.study.service.impl;

import com.asian.backend.dbprovider.StudyRepository;
import com.asian.backend.domains.dto.StudyDTO;
import com.asian.backend.domains.entity.StudyEntity;
import com.asian.backend.study.service.StudyService;
import com.asian.backend.utils.convert.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author datdv
 */
@Service
public class StudyServiceImpl implements StudyService {

    private final StudyRepository studyRepository;

    @Autowired
    public StudyServiceImpl(StudyRepository studyRepository){
        this.studyRepository = studyRepository;
    }


    @Override
    @Transactional
    public StudyDTO save(StudyDTO input) {
        StudyEntity entity = Converter.toModel(input , StudyEntity.class);
        return Converter.toModel(studyRepository.save(entity) , StudyDTO.class);
    }
}
