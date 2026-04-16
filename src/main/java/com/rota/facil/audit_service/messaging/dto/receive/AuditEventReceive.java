package com.rota.facil.audit_service.messaging.dto.receive;

import java.util.UUID;

public record AuditEventReceive(
        UUID userId,
        String role,
        String actionTitle,
        String actionType,
        String resourceName,
        UUID resourceId
) {
}
