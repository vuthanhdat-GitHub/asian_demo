package com.asian.backend.domains.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudyDTO extends AbstractDTO<StudyDTO> {

    private String studyName;
    private Integer status;
    private Integer base;

}
