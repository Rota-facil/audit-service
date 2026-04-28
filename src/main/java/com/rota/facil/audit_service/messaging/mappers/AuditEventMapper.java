package com.rota.facil.audit_service.messaging.mappers;

import com.rota.facil.audit_service.messaging.dto.receive.AuditEventReceive;
import com.rota.facil.audit_service.persistence.entities.AuditEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface AuditEventMapper {
    AuditEntity map(AuditEventReceive eventReceive);
}
