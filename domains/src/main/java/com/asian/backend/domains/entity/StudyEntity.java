package com.asian.backend.domains.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author datdv
 */
@Entity
@Table(name = "study")
@Getter
@Setter
public class StudyEntity extends BaseEntity {

    private String studyName;
    private Integer status;
    private Integer base;

}
