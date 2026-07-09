package com.rota.facil.audit_service.messaging.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Value("${rabbitmq.auth.exchange}")
    private String authExchange;

    @Value("${rabbitmq.file.exchange}")
    private String fileExchange;

    @Value("${rabbitmq.places.exchange}")
    private String placesExchange;

    @Value("${rabbitmq.transport.exchange}")
    private String transportExchange;

    @Value("${rabbitmq.audit.auth.queue}")
    private String auditAuthQueue;

    @Value("${rabbitmq.audit.file.queue}")
    private String auditFileQueue;

    @Value("${rabbitmq.audit.places.queue}")
    private String auditPlacesQueue;

    @Value("${rabbitmq.audit.transport.queue}")
    private String auditTransportQueue;

    @Value("${rabbitmq.user.created.routing.key}")
    private String userCreatedRoutingKey;

    @Value("${rabbitmq.user.updated.routing.key}")
    private String userUpdatedRoutingKey;

    @Value("${rabbitmq.user.deleted.routing.key}")
    private String userDeletedRoutingKey;

    @Value("${rabbitmq.user.email.changed.routing.key}")
    private String userEmailChangedRoutingKey;

    @Value("${rabbitmq.user.deactivate.routing.key}")
    private String userDeactivateRoutingKey;

    @Value("${rabbitmq.user.logout.routing.key}")
    private String userLogoutRoutingKey;

    @Value("${rabbitmq.user.feedback.routing.key}")
    private String userFeedbackRoutingKey;

    @Value("${rabbitmq.driver.admin.updated.routing.key}")
    private String driverAdminUpdatedRoutingKey;

    @Value("${rabbitmq.prefecture.created.routing.key}")
    private String prefectureCreatedRoutingKey;

    @Value("${rabbitmq.prefecture.updated.routing.key}")
    private String prefectureUpdatedRoutingKey;

    @Value("${rabbitmq.prefecture.deleted.routing.key}")
    private String prefectureDeletedRoutingKey;

    @Value("${rabbitmq.file.created.routing.key}")
    private String fileCreatedRoutingKey;

    @Value("${rabbitmq.file.updated.routing.key}")
    private String fileUpdatedRoutingKey;

    @Value("${rabbitmq.file.deleted.routing.key}")
    private String fileDeletedRoutingKey;

    @Value("${rabbitmq.institution.created.routing.key}")
    private String institutionCreatedRoutingKey;

    @Value("${rabbitmq.institution.updated.routing.key}")
    private String institutionUpdatedRoutingKey;

    @Value("${rabbitmq.institution.deleted.routing.key}")
    private String institutionDeletedRoutingKey;

    @Value("${rabbitmq.boarding.created.routing.key}")
    private String boardCreatedRoutingKey;

    @Value("${rabbitmq.boarding.updated.routing.key}")
    private String boardUpdatedRoutingKey;

    @Value("${rabbitmq.boarding.deleted.routing.key}")
    private String boardDeletedRoutingKey;

    @Value("${rabbitmq.route.created.routing.key}")
    private String routeCreatedRoutingKey;

    @Value("${rabbitmq.route.updated.routing.key}")
    private String routeUpdatedRoutingKey;

    @Value("${rabbitmq.route.deleted.routing.key}")
    private String routeDeletedRoutingKey;

    @Value("${rabbitmq.trip.running.routing.key}")
    private String tripRunningRoutingKey;

    @Value("${rabbitmq.trip.cancelled.routing.key}")
    private String tripCancelledRoutingKey;

    @Value("${rabbitmq.trip.deleted.routing.key}")
    private String tripDeletedRoutingKey;

    @Value("${rabbitmq.bus.created.routing.key}")
    private String busCreatedRoutingKey;

    @Value("${rabbitmq.bus.updated.routing.key}")
    private String busUpdatedRoutingKey;

    @Value("${rabbitmq.bus.deleted.routing.key}")
    private String busDeletedRoutingKey;

    @Bean
    public Jackson2JsonMessageConverter messageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(
            ConnectionFactory connectionFactory,
            Jackson2JsonMessageConverter messageConverter
    ) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter);
        return template;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
            ConnectionFactory connectionFactory,
            Jackson2JsonMessageConverter messageConverter
    ) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(messageConverter);
        return factory;
    }

    @Bean
    public TopicExchange authExchange() {
        return new TopicExchange(authExchange);
    }

    @Bean
    public TopicExchange filesExchange() {
        return new TopicExchange(fileExchange);
    }

    @Bean
    public TopicExchange placesExchange() {
        return new TopicExchange(placesExchange);
    }

    @Bean
    public TopicExchange transportExchange() {
        return new TopicExchange(transportExchange);
    }

    @Bean
    public Queue auditAuthQueue() {
        return new Queue(auditAuthQueue);
    }

    @Bean
    public Queue auditFileQueue() {
        return new Queue(auditFileQueue);
    }

    @Bean
    public Queue auditPlacesQueue() {
        return new Queue(auditPlacesQueue);
    }

    @Bean
    public Queue auditTransportQueue() {
        return new Queue(auditTransportQueue);
    }

    @Bean
    public Binding userCreatedAuditBinding() {
        return BindingBuilder.bind(this.auditAuthQueue()).to(this.authExchange()).with(this.userCreatedRoutingKey);
    }

    @Bean
    public Binding userUpdatedAuditBinding() {
        return BindingBuilder.bind(this.auditAuthQueue()).to(this.authExchange()).with(this.userUpdatedRoutingKey);
    }

    @Bean
    public Binding userDeletedAuditBinding() {
        return BindingBuilder.bind(this.auditAuthQueue()).to(this.authExchange()).with(this.userDeletedRoutingKey);
    }

    @Bean
    public Binding userEmailChangedAuditBinding() {
        return BindingBuilder.bind(this.auditAuthQueue()).to(this.authExchange()).with(this.userEmailChangedRoutingKey);
    }

    @Bean
    public Binding userDeactivateAuditBinding() {
        return BindingBuilder.bind(this.auditAuthQueue()).to(this.authExchange()).with(this.userDeactivateRoutingKey);
    }

    @Bean
    public Binding userLogoutAuditBinding() {
        return BindingBuilder.bind(this.auditAuthQueue()).to(this.authExchange()).with(this.userLogoutRoutingKey);
    }


    @Bean
    public Binding userFeedbackAuditBinding() {
        return BindingBuilder.bind(this.auditTransportQueue()).to(this.transportExchange()).with(this.userFeedbackRoutingKey);
    }


    
    @Bean
    public Binding driverAdminUpdatedAuditBinding() {
        return BindingBuilder.bind(this.auditAuthQueue()).to(this.authExchange()).with(this.driverAdminUpdatedRoutingKey);
    }

    @Bean
    public Binding prefectureCreatedAuditBinding() {
        return BindingBuilder.bind(this.auditAuthQueue()).to(this.authExchange()).with(this.prefectureCreatedRoutingKey);
    }

    @Bean
    public Binding prefectureUpdatedAuditBinding() {
        return BindingBuilder.bind(this.auditAuthQueue()).to(this.authExchange()).with(this.prefectureUpdatedRoutingKey);
    }

    @Bean
    public Binding prefectureDeletedAuditBinding() {
        return BindingBuilder.bind(this.auditAuthQueue()).to(this.authExchange()).with(this.prefectureDeletedRoutingKey);
    }

    @Bean
    public Binding fileCreatedAuditBinding() {
        return BindingBuilder.bind(this.auditFileQueue()).to(this.filesExchange()).with(this.fileCreatedRoutingKey);
    }

    @Bean
    public Binding fileUpdatedAuditBinding() {
        return BindingBuilder.bind(this.auditFileQueue()).to(this.filesExchange()).with(this.fileUpdatedRoutingKey);
    }

    @Bean
    public Binding fileDeletedAuditBinding() {
        return BindingBuilder.bind(this.auditFileQueue()).to(this.filesExchange()).with(this.fileDeletedRoutingKey);
    }

    @Bean
    public Binding institutionCreatedAuditBinding() {
        return BindingBuilder.bind(this.auditPlacesQueue()).to(this.placesExchange()).with(this.institutionCreatedRoutingKey);
    }

    @Bean
    public Binding institutionUpdatedAuditBinding() {
        return BindingBuilder.bind(this.auditPlacesQueue()).to(this.placesExchange()).with(this.institutionUpdatedRoutingKey);
    }

    @Bean
    public Binding institutionDeletedAuditBinding() {
        return BindingBuilder.bind(this.auditPlacesQueue()).to(this.placesExchange()).with(this.institutionDeletedRoutingKey);
    }

    @Bean
    public Binding boardCreatedAuditBinding() {
        return BindingBuilder.bind(this.auditPlacesQueue()).to(this.placesExchange()).with(this.boardCreatedRoutingKey);
    }

    @Bean
    public Binding boardUpdatedAuditBinding() {
        return BindingBuilder.bind(this.auditPlacesQueue()).to(this.placesExchange()).with(this.boardUpdatedRoutingKey);
    }

    @Bean
    public Binding boardDeletedAuditBinding() {
        return BindingBuilder.bind(this.auditPlacesQueue()).to(this.placesExchange()).with(this.boardDeletedRoutingKey);
    }

    @Bean
    public Binding routeCreatedAuditBinding() {
        return BindingBuilder.bind(this.auditTransportQueue()).to(this.transportExchange()).with(this.routeCreatedRoutingKey);
    }

    @Bean
    public Binding routeUpdatedAuditBinding() {
        return BindingBuilder.bind(this.auditTransportQueue()).to(this.transportExchange()).with(this.routeUpdatedRoutingKey);
    }

    @Bean
    public Binding routeDeletedAuditBinding() {
        return BindingBuilder.bind(this.auditTransportQueue()).to(this.transportExchange()).with(this.routeDeletedRoutingKey);
    }

    @Bean
    public Binding busCreatedAuditBinding() {
        return BindingBuilder.bind(this.auditTransportQueue()).to(this.transportExchange()).with(this.busCreatedRoutingKey);
    }

    @Bean
    public Binding busUpdatedAuditBinding() {
        return BindingBuilder.bind(this.auditTransportQueue()).to(this.transportExchange()).with(this.busUpdatedRoutingKey);
    }

    @Bean
    public Binding busDeletedAuditBinding() {
        return BindingBuilder.bind(this.auditTransportQueue()).to(this.transportExchange()).with(this.busDeletedRoutingKey);
    }

    
    @Bean
    public Binding tripRunningAuditBinding() {
        return BindingBuilder.bind(this.auditTransportQueue()).to(this.transportExchange()).with(this.tripRunningRoutingKey);
    }

    @Bean
    public Binding tripCancelledAuditBinding() {
        return BindingBuilder.bind(this.auditTransportQueue()).to(this.transportExchange()).with(this.tripCancelledRoutingKey);
    }


    @Bean
    public Binding tripDeletedAuditBinding() {
        return BindingBuilder.bind(this.auditTransportQueue()).to(this.transportExchange()).with(this.tripDeletedRoutingKey);
    }
}
