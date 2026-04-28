package com.rota.facil.audit_service.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Entity
@Table(name = "audit_tb")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "audit_id")
    private UUID id;

    @Column(name = "user_id")
    private UUID userId;

    private String role;

    @Column(name = "action_title")
    private String actionTitle;

    @Column(name = "action_type")
    private String actionType;

    @Column(name = "resource_name")
    String resourceName;

    @Column(name = "resource_id")
    UUID resourceId;
}
