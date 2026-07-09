package com.rota.facil.audit_service.http.dto.response.audit;

import java.time.LocalDateTime;
import java.util.UUID;

public record AuditResponseDTO(
        UUID id,
        UUID userId,
        UUID prefectureId,
        String email,
        String role,
        String actionTitle,
        String actionType,
        String resourceName,
        UUID resourceId,
        LocalDateTime createdAt
) {
}
