package com.asian.backend.utils.repositoryCustomUtil;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class RepositoryCustomUtil<T> {
    @PersistenceContext
    private EntityManager entityManager;

    private Query createQuery(EntityManager entityManager, String sql, String resulsetMappingName, Map<String, Object> parameter, Class zClass) {
        Query query = null;
        if (StringUtils.isEmpty(resulsetMappingName)) {
            if (zClass != null) {
                query = entityManager.createNativeQuery(sql, zClass);

            } else {
                query = entityManager.createNativeQuery(sql);
            }
        } else {
            query = entityManager.createNativeQuery(sql, resulsetMappingName);
        }
        if (parameter == null) {
            return query;
        }
        Query finalQuery = query;
        for (Map.Entry<String, Object> entry : parameter.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        query = finalQuery;
        return query;
    }

    private <T> List<T> getResultList(String sql, String resulsetMappingName, Map<String, Object> parameters, Class zClass, Pageable pageable) {
        try {
            Query query = createQuery(entityManager, sql, resulsetMappingName, parameters, zClass);
            if (pageable != null) {
                query.setFirstResult((int) pageable.getOffset());
                query.setMaxResults(pageable.getPageSize());
            }
            return query.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public <T> List<T> getResultList(String sql, Class zClass, Map<String, Object> parameter, Pageable pageable) {
        return getResultList(sql, null, parameter, zClass, pageable);
    }

    public <T> List<T> getResultList(String sql, String resultSetMappingName, Map<String, Object> parameter) {
        return getResultList(sql, resultSetMappingName, parameter, null, null);
    }

    public <T> List<T> getResultList(String sql, Class zClass, Map<String, Object> parameter) {
        return getResultList(sql, null, parameter, zClass, null);
    }
}
