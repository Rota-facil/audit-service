package com.rota.facil.audit_service.messaging.consumers;

import com.rota.facil.audit_service.messaging.dto.receive.AuditEventReceive;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitTransportEventConsumer {
    // inejtar service que vai converter isso para uma entidade e vai persistir

    @RabbitListener(queues = {
            "${rabbitmq.audit.route.created.queue}",
            "${rabbitmq.audit.route.updated.queue}",
            "${rabbitmq.audit.route.deleted.queue}",
            "${rabbitmq.audit.trip.running.queue}",
            "${rabbitmq.audit.trip.cancelled.queue}"
    })
    public void handlerTransportEvent(AuditEventReceive auditEventReceive) {

    }
}
