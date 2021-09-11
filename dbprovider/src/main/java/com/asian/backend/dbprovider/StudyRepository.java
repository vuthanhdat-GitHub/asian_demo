package com.asian.backend.dbprovider;

import com.asian.backend.domains.entity.StudyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author datdv
 */
@Repository
public interface StudyRepository extends JpaRepository<StudyEntity , Long> {

}
