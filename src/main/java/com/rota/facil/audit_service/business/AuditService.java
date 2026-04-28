package com.rota.facil.audit_service.business;

import com.rota.facil.audit_service.http.dto.response.audit.AuditResponseDTO;
import com.rota.facil.audit_service.persistence.entities.AuditEntity;
import com.rota.facil.audit_service.persistence.mappers.AuditMapper;
import com.rota.facil.audit_service.persistence.repositories.AuditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditService {
    private final AuditRepository auditRepository;
    private final AuditMapper auditMapper;

    public void register(AuditEntity entity) {
        auditRepository.save(entity);
    }

    public List<AuditResponseDTO> list() {
        return auditRepository.findAll().stream()
                .map(auditMapper::map)
                .toList();
    }
}
