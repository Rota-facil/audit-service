package com.rota.facil.audit_service.http.controllers;

import com.rota.facil.audit_service.business.AuditService;
import com.rota.facil.audit_service.http.dto.response.audit.AuditResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuditController {
    private final AuditService auditService;

    @GetMapping
    public ResponseEntity<List<AuditResponseDTO>> listAudit() {
        return ResponseEntity.ok(auditService.list());
    }
}
