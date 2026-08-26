package com.rota.facil.audit_service.http.controllers;

import com.rota.facil.audit_service.business.AuditService;
import com.rota.facil.audit_service.business.audits.ListAuditUseCase;
import com.rota.facil.audit_service.http.dto.request.CurrentUser;
import com.rota.facil.audit_service.http.dto.response.audit.AuditResponseDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuditController {
    private final ListAuditUseCase listAuditUseCase;

    @GetMapping
    public ResponseEntity<List<AuditResponseDTO>> listAudit(
            @AuthenticationPrincipal CurrentUser currentUser,
            @RequestParam(required = false) String actor,
            @RequestParam(required = false) String action
    ) {
        return ResponseEntity.ok(listAuditUseCase.list(currentUser.prefectureId(), actor, action));
    }
}
