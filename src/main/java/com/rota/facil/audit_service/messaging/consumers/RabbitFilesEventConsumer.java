package com.rota.facil.audit_service.messaging.consumers;

import com.rota.facil.audit_service.business.AuditService;
import com.rota.facil.audit_service.messaging.dto.receive.AuditEventReceive;
import com.rota.facil.audit_service.messaging.mappers.AuditEventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitFilesEventConsumer {
    private final AuditService auditService;
    private final AuditEventMapper auditEventMapper;

    @RabbitListener(queues = {
            "${rabbitmq.audit.file.created.queue}",
            "${rabbitmq.audit.file.updated.queue}",
            "${rabbitmq.audit.file.deleted.queue}"
    })
    public void handleFilesEvent(AuditEventReceive auditEventReceive) {
        auditService.register(auditEventMapper.map(auditEventReceive));
    }
}
