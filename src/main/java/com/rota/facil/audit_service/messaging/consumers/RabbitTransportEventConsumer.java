package com.rota.facil.audit_service.messaging.consumers;

import com.rota.facil.audit_service.business.AuditService;
import com.rota.facil.audit_service.messaging.dto.receive.AuditEventReceive;
import com.rota.facil.audit_service.messaging.mappers.AuditEventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitTransportEventConsumer {
    private final AuditService auditService;
    private final AuditEventMapper auditEventMapper;

    @RabbitListener(queues = "${rabbitmq.audit.transport.queue}")
    public void handlerTransportEvent(AuditEventReceive auditEventReceive) {
        auditService.register(auditEventMapper.map(auditEventReceive));
    }
}
