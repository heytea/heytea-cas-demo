package com.heytea.demo.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConsumerConfig {

    // 消费者不需要关系 excahnge，只需要用队列 queue 就可以
    // static final String topicExchangeName = "heytea.sso.exchange.topic";
    static final String queueName = "heytea.sso.oa.queue";

    @Bean
    public Queue queue() {
        // return QueueBuilder.durable(queueName).build();
        return new Queue(queueName);
    }

    @Bean
    public SimpleRabbitListenerContainerFactory containerFactory(ConnectionFactory connectionFactory,
        SimpleRabbitListenerContainerFactoryConfigurer configurer) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        configurer.configure(factory, connectionFactory);
        return factory;
    }

}
