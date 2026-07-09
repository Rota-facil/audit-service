package com.rota.facil.audit_service.persistence.repositories;

import com.rota.facil.audit_service.persistence.entities.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AuditRepository extends JpaRepository<AuditEntity, UUID> {
    @Query("""
        SELECT a FROM AuditEntity a
        WHERE a.prefectureId = :prefectureId
        AND (:actor IS NULL OR LOWER(a.email) LIKE LOWER(CONCAT('%', :actor, '%')))
        AND (:action IS NULL OR a.actionType = :action)
        ORDER BY a.createdAt DESC
    """)
    List<AuditEntity> findAllByPrefectureWithFilters(
            @Param("prefectureId") UUID prefectureId,
            @Param("actor") String actor,
            @Param("action") String action
    );
}
