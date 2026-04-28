package com.rota.facil.audit_service.persistence.mappers;

import com.rota.facil.audit_service.http.dto.response.audit.AuditResponseDTO;
import com.rota.facil.audit_service.persistence.entities.AuditEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface AuditMapper {
    AuditResponseDTO map(AuditEntity entity);
}
