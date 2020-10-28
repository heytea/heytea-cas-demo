package com.heytea.demo.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.AMQP.Queue.DeclareOk;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class NonSpringReceiverDemo {

    private static final String QUEUE_NAME = RabbitmqMessagingConsumer.queueName;

    public static void main(String[] args) throws IOException, TimeoutException {
        
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("rabbitmq");
        factory.setPort(30007);
        factory.setVirtualHost("dev-sso-vhost");
        factory.setUsername("dev-sso");
        factory.setPassword("dev-sso-password");
        
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        DeclareOk ok = channel.queueDeclarePassive(QUEUE_NAME);

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        
        // TODO 根据实际情况进行自动 ACK 或者收到 ACK
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}