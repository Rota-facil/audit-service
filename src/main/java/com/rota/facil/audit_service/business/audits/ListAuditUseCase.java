package com.rota.facil.audit_service.business.audits;

import com.rota.facil.audit_service.http.dto.response.audit.AuditResponseDTO;
import com.rota.facil.audit_service.persistence.mappers.AuditMapper;
import com.rota.facil.audit_service.persistence.repositories.AuditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ListAuditUseCase {
    private final AuditRepository auditRepository;
    private final AuditMapper auditMapper;

    public List<AuditResponseDTO> execute(UUID prefectureId, String actor, String action) {
        return auditRepository.findAllByPrefectureWithFilters(prefectureId, normalize(actor), normalize(action)).stream()
                .map(auditMapper::map)
                .toList();
    }

    private String normalize(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }

        return value.trim();
    }
}
