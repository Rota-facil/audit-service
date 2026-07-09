package com.rota.facil.audit_service.messaging.mappers;

import com.rota.facil.audit_service.messaging.dto.receive.AuditEventReceive;
import com.rota.facil.audit_service.persistence.entities.AuditEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuditEventMapper {
    default AuditEntity map(AuditEventReceive eventReceive) {
        AuditEntity auditEntity = new AuditEntity();
        auditEntity.setUserId(eventReceive.actorUserId() != null ? eventReceive.actorUserId() : eventReceive.userId());
        auditEntity.setPrefectureId(eventReceive.prefectureId());
        auditEntity.setEmail(eventReceive.actorEmail() != null ? eventReceive.actorEmail() : eventReceive.userEmail());
        auditEntity.setRole(eventReceive.actorRole() != null ? eventReceive.actorRole() : eventReceive.role());
        auditEntity.setActionTitle(eventReceive.actionTitle());
        auditEntity.setActionType(eventReceive.actionType());
        auditEntity.setResourceName(eventReceive.resourceName());
        auditEntity.setResourceId(eventReceive.resourceId());
        return auditEntity;
    }
}
