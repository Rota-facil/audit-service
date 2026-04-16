package com.rota.facil.audit_service.messaging.consumers;

import com.rota.facil.audit_service.messaging.dto.receive.AuditEventReceive;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitAuthEventConsumer {
    // inejtar service que vai converter isso para uma entidade e vai persistir

    @RabbitListener(queues = {
            "${rabbitmq.audit.user.created.queue}",
            "${rabbitmq.audit.user.updated.queue}",
            "${rabbitmq.audit.user.deleted.queue}",
            "${rabbitmq.audit.prefecture.created.queue}",
            "${rabbitmq.audit.prefecture.updated.queue}",
            "${rabbitmq.audit.prefecture.deleted.queue}"
    })
    public void handlerFileEvent(AuditEventReceive auditEventReceive) {
        System.out.println(auditEventReceive);
    }
}
