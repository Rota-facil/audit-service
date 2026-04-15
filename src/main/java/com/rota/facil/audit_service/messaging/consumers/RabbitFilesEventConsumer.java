package com.rota.facil.audit_service.messaging.consumers;

import com.rota.facil.audit_service.messaging.dto.receive.AuditEventReceive;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitFilesEventConsumer {
    // inejtar service que vai converter isso para uma entidade e vai persistir

    @RabbitListener(queues = {
            "${rabbitmq.audit.file.created.queue}",
            "${rabbitmq.audit.file.updated.queue}",
            "${rabbitmq.audit.file.deleted.queue}"
    })
    public void handleFilesEvent(AuditEventReceive auditEventReceive) {

    }
}
