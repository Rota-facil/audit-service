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
        WHERE (a.email = :actor OR a.email IS NULL)
        AND (a.actionType = :action OR a.actionType IS NULL)
    """)
    List<AuditEntity> findAllWithActorAndAction(@Param("actor") String actor, @Param("action") String action);
}
