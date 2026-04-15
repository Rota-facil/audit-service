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

    @Value("${rabbitmq.audit.user.creted.queue}")
    private String userCreatedQueue;

    @Value("${rabbitmq.audit.user.updated.queue}")
    private String userUpdatedQueue;

    @Value("${rabbitmq.audit.user.deleted.queue}")
    private String userDeletedQueue;

    @Value("${rabbitmq.audit.prefecture.created.queue}")
    private String prefectureCreatedQueue;

    @Value("${rabbitmq.audit.prefecture.updated.queue}")
    private String prefectureUpdatedQueue;

    @Value("${rabbitmq.audit.prefecture.deleted.queue}")
    private String prefectureDeletedQueue;


    @Value("${rabbitmq.user.created.routing.key}")
    private String userCreatedRoutingKey;

    @Value("${rabbitmq.user.updated.routing.key}")
    private String userUpdatedRoutingKey;

    @Value("${rabbitmq.user.deleted.routing.key}")
    private String userDeletedRoutingKey;

    @Value("${rabbitmq.prefecture.created.routing.key}")
    private String prefectureCreatedRoutingKey;

    @Value("${rabbitmq.prefecture.updated.routing.key}")
    private String prefectureUpdatedRoutingKey;

    @Value("${rabbitmq.prefecture.deleted.routing.key}")
    private String prefectureDeletedRoutingKey;



    @Value("${rabbitmq.file.exchange}")
    private String fileExchange;

    @Value("${rabbitmq.audit.file.created.queue}")
    private String fileCreatedQueue;

    @Value("${rabbitmq.audit.file.updated.queue}")
    private String fileUpdatedQueue;

    @Value("${rabbitmq.audit.file.deleted.queue}")
    private String fileDeletedQueue;

    @Value("${rabbitmq.file.created.routing.key}")
    private String fileCreatedRoutingKet;

    @Value("${rabbitmq.file.updated.routing.key}")
    private String fileUpdatedRoutingKet;

    @Value("${rabbitmq.file.deleted.routing.key}")
    private String fileDeletedRoutingKet;



    @Value("${rabbitmq.places.exchange}")
    private String placesExchange;

    @Value("${rabbitmq.audit.institution.created.queue}")
    private String institutionCreatedQueue;

    @Value("${rabbitmq.audit.institution.updated.queue}")
    private String institutionUpdatedQueue;

    @Value("${rabbitmq.audit.institution.deleted.queue}")
    private String institutionDeletedQueue;


    @Value("${rabbitmq.audit.boarding.created.queue}")
    private String boardCreatedQueue;

    @Value("${rabbitmq.audit.boarding.updated.queue}")
    private String boardUpdatedQueue;

    @Value("${rabbitmq.audit.boarding.deleted.queue}")
    private String boardDeletedQueue;

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



    @Value("${rabbitmq.transport.exchange}")
    private String transportExchange;

    @Value("${rabbitmq.audit.route.created.queue}")
    private String routeCreatedQueue;

    @Value("${rabbitmq.audit.route.updated.queue}")
    private String routeUpdatedQueue;

    @Value("${rabbitmq.audit.route.deleted.queue}")
    private String routeDeletedQueue;

    @Value("${rabbitmq.audit.trip.running.queue}")
    private String tripRunningQueue;

    @Value("${rabbitmq.audit.trip.cancelled.queue}")
    private String tripCancelledQueue;


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


    @Bean
    public Jackson2JsonMessageConverter messageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    public RabbitTemplate rabbitListener(
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
        SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory = new SimpleRabbitListenerContainerFactory();
        simpleRabbitListenerContainerFactory.setConnectionFactory(connectionFactory);
        simpleRabbitListenerContainerFactory.setMessageConverter(messageConverter);
        return simpleRabbitListenerContainerFactory;
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
    public Queue userCreatedQueue() {
        return new Queue(userCreatedQueue);
    }

    @Bean
    public Queue userUpdatedQueue() {
        return new Queue(userUpdatedQueue);
    }

    @Bean
    public Queue userDeletedQueue() {
        return new Queue(userDeletedQueue);
    }

    @Bean
    public Queue prefectureCreatedQueue() {
        return new Queue(prefectureCreatedQueue);
    }

    @Bean
    public Queue prefectureUpdatedQueue() {
        return new Queue(prefectureUpdatedQueue);
    }

    @Bean
    public Queue prefectureDeletedQueue() {
        return new Queue(prefectureDeletedQueue);
    }


    @Bean
    public Queue fileCreatedQueue() {
        return new Queue(fileCreatedQueue);
    }

    @Bean
    public Queue fileUpdatedQueue() {
        return new Queue(fileUpdatedQueue);
    }

    @Bean
    public Queue fileDeletedQueue() {
        return new Queue(fileDeletedQueue);
    }


    @Bean
    public Queue institutionCreatedQueue() {
        return new Queue(institutionCreatedQueue);
    }

    @Bean
    public Queue institutionUpdatedQueue() {
        return new Queue(institutionUpdatedQueue);
    }

    @Bean
    public Queue institutionDeletedQueue() {
        return new Queue(institutionDeletedQueue);
    }

    @Bean
    public Queue boardCreatedQueue() {
        return new Queue(boardCreatedQueue);
    }

    @Bean
    public Queue boardUpdatedQueue() {
        return new Queue(boardUpdatedQueue);
    }

    @Bean
    public Queue boardDeletedQueue() {
        return new Queue(boardDeletedQueue);
    }

    @Bean
    public Queue routeCreatedQueue() {
        return new Queue(routeCreatedQueue);
    }

    @Bean
    public Queue routeUpdatedQueue() {
        return new Queue(routeUpdatedQueue);
    }

    @Bean
    public Queue routeDeletedQueue() {
        return new Queue(routeDeletedQueue);
    }


    @Bean
    public Queue tripRunningQueue() {
        return new Queue(tripRunningQueue);
    }

    @Bean
    public Queue tripCancelledQueue() {
        return new Queue(tripCancelledQueue);
    }

    @Bean
    public Binding userCreatedBinding() {
        return BindingBuilder.bind(this.userCreatedQueue()).to(this.authExchange()).with(this.userCreatedRoutingKey);
    }

    @Bean
    public Binding userUpdatedBinding() {
        return BindingBuilder.bind(this.userUpdatedQueue()).to(this.authExchange()).with(this.userUpdatedRoutingKey);
    }

    @Bean
    public Binding userDeletedBinding() {
        return BindingBuilder.bind(this.userDeletedQueue()).to(this.authExchange()).with(this.userDeletedRoutingKey);
    }


    @Bean
    public Binding prefectureCreatedBinding() {
        return BindingBuilder.bind(this.prefectureCreatedQueue()).to(this.authExchange()).with(this.prefectureCreatedRoutingKey);
    }

    @Bean
    public Binding prefectureUpdatedBinding() {
        return BindingBuilder.bind(this.prefectureUpdatedQueue()).to(this.authExchange()).with(this.prefectureUpdatedRoutingKey);
    }

    @Bean
    public Binding prefectureDeletedBinding() {
        return BindingBuilder.bind(this.prefectureDeletedQueue()).to(this.authExchange()).with(this.prefectureDeletedRoutingKey);
    }

    @Bean
    public Binding fileCreatedBinding() {
        return BindingBuilder.bind(this.fileCreatedQueue()).to(this.filesExchange()).with(this.fileCreatedRoutingKet);
    }

    @Bean
    public Binding fileUpdatedBinding() {
        return BindingBuilder.bind(this.fileUpdatedQueue()).to(this.filesExchange()).with(this.fileUpdatedRoutingKet);
    }

    @Bean
    public Binding fileDeletedBinding() {
        return BindingBuilder.bind(this.fileDeletedQueue()).to(this.filesExchange()).with(this.fileDeletedRoutingKet);
    }

    @Bean
    public Binding institutionCreatedBinding() {
        return BindingBuilder.bind(this.institutionCreatedQueue()).to(this.placesExchange()).with(this.institutionCreatedRoutingKey);
    }

    @Bean
    public Binding institutionUpdatedBinding() {
        return BindingBuilder.bind(this.institutionUpdatedQueue()).to(this.placesExchange()).with(this.institutionUpdatedRoutingKey);
    }

    @Bean
    public Binding institutionDeletedBinding() {
        return BindingBuilder.bind(this.institutionDeletedQueue()).to(this.placesExchange()).with(this.institutionDeletedRoutingKey);
    }

    @Bean
    public Binding boardCreatedBinding() {
        return BindingBuilder.bind(this.boardCreatedQueue()).to(this.placesExchange()).with(this.boardCreatedRoutingKey);
    }

    @Bean
    public Binding boardUpdatedBinding() {
        return BindingBuilder.bind(this.boardUpdatedQueue()).to(this.placesExchange()).with(this.boardUpdatedRoutingKey);
    }

    @Bean
    public Binding boardDeletedBinding() {
        return BindingBuilder.bind(this.boardDeletedQueue()).to(this.placesExchange()).with(this.boardDeletedRoutingKey);
    }

    @Bean
    public Binding routeCreatedBinding() {
        return BindingBuilder.bind(this.routeCreatedQueue()).to(this.transportExchange()).with(this.routeCreatedRoutingKey);
    }

    @Bean
    public Binding routeUpdatedBinding() {
        return BindingBuilder.bind(this.routeUpdatedQueue()).to(this.transportExchange()).with(this.routeUpdatedRoutingKey);
    }

    @Bean
    public Binding routeDeletedBinding() {
        return BindingBuilder.bind(this.routeDeletedQueue()).to(this.transportExchange()).with(this.routeDeletedRoutingKey);
    }


    @Bean
    public Binding tripRunningBinding() {
        return BindingBuilder.bind(this.tripRunningQueue()).to(this.transportExchange()).with(this.tripRunningRoutingKey);
    }

    @Bean
    public Binding tripCancelledBinding() {
        return BindingBuilder.bind(this.tripCancelledQueue()).to(this.transportExchange()).with(this.tripCancelledRoutingKey);
    }
}
