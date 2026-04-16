package com.rota.facil.audit_service.messaging.consumers;

import com.rota.facil.audit_service.messaging.dto.receive.AuditEventReceive;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitPlacesEventConsumer {
    // inejtar service que vai converter isso para uma entidade e vai persistir

    @RabbitListener(queues = {
            "${rabbitmq.audit.institution.created.queue}",
            "${rabbitmq.audit.institution.updated.queue}",
            "${rabbitmq.audit.institution.deleted.queue}",
            "${rabbitmq.audit.boarding.created.queue}",
            "${rabbitmq.audit.boarding.updated.queue}",
            "${rabbitmq.audit.boarding.deleted.queue}"
    })
    public void handlerPlacesEvent(AuditEventReceive auditEventReceive) {

    }
}
