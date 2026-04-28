package com.rota.facil.audit_service.http.dto.response.audit;

import java.util.UUID;

public record AuditResponseDTO(
        UUID id,
        UUID userId,
        String role,
        String actionTitle,
        String actionType,
        String resourceName,
        UUID resourceId
) {
}
