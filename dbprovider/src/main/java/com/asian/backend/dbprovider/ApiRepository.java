package com.asian.backend.dbprovider;


import com.asian.backend.domains.entity.ApiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends JpaRepository<ApiEntity, Integer> {
    ApiEntity findOneById(Integer id);
}