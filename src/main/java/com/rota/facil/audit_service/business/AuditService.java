package com.rota.facil.audit_service.business;

import com.rota.facil.audit_service.http.dto.response.audit.AuditResponseDTO;
import com.rota.facil.audit_service.persistence.entities.AuditEntity;
import com.rota.facil.audit_service.persistence.mappers.AuditMapper;
import com.rota.facil.audit_service.persistence.repositories.AuditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuditService {
    private final AuditRepository auditRepository;
    private final AuditMapper auditMapper;

    public void register(AuditEntity entity) {
        auditRepository.save(entity);
    }

}
