package com.rota.facil.audit_service.persistence.repositories;

import com.rota.facil.audit_service.persistence.entities.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuditRepository extends JpaRepository<AuditEntity, UUID> {
}
