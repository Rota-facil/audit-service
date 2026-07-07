package com.rota.facil.audit_service.messaging.mappers;

import com.rota.facil.audit_service.messaging.dto.receive.AuditEventReceive;
import com.rota.facil.audit_service.persistence.entities.AuditEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuditEventMapper {
    default AuditEntity map(AuditEventReceive eventReceive) {
        return AuditEntity.builder()
                .userId(eventReceive.actorUserId() != null ? eventReceive.actorUserId() : eventReceive.userId())
                .email(eventReceive.actorEmail() != null ? eventReceive.actorEmail() : eventReceive.userEmail())
                .role(eventReceive.actorRole() != null ? eventReceive.actorRole() : eventReceive.role())
                .actionTitle(eventReceive.actionTitle())
                .actionType(eventReceive.actionType())
                .resourceName(eventReceive.resourceName())
                .resourceId(eventReceive.resourceId())
                .build();
    }
}
