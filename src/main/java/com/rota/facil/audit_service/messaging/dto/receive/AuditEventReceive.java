package com.rota.facil.audit_service.messaging.dto.receive;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.UUID;

public record AuditEventReceive(
        UUID userId,
        UUID prefectureId,
        @JsonAlias("email") String userEmail,
        String role,
        UUID actorUserId,
        String actorEmail,
        String actorRole,
        String actionTitle,
        String actionType,
        String resourceName,
        UUID resourceId
) {
}
