package com.rota.facil.audit_service.messaging.consumers;

import com.rota.facil.audit_service.business.AuditService;
import com.rota.facil.audit_service.messaging.dto.receive.AuditEventReceive;
import com.rota.facil.audit_service.messaging.mappers.AuditEventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitPlacesEventConsumer {
    private final AuditService auditService;
    private final AuditEventMapper auditEventMapper;

    @RabbitListener(queues = {
            "${rabbitmq.audit.institution.created.queue}",
            "${rabbitmq.audit.institution.updated.queue}",
            "${rabbitmq.audit.institution.deleted.queue}",
            "${rabbitmq.audit.boarding.created.queue}",
            "${rabbitmq.audit.boarding.updated.queue}",
            "${rabbitmq.audit.boarding.deleted.queue}"
    })
    public void handlerPlacesEvent(AuditEventReceive auditEventReceive) {
        auditService.register(auditEventMapper.map(auditEventReceive));
    }
}
