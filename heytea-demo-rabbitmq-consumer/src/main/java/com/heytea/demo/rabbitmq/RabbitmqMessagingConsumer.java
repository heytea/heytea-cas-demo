package com.heytea.demo.rabbitmq;

import java.util.Objects;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heytea.demo.rabbitmq.model.HeyteaMQBody;
import com.heytea.demo.rabbitmq.model.dto.EntityChangeDTO;
import com.heytea.demo.rabbitmq.model.dto.SfEmployeeJob;
import com.heytea.demo.rabbitmq.model.dto.ShopUser;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RabbitmqMessagingConsumer {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static final String queueName = "heytea.sso.oa.queue";

    @SneakyThrows(JsonProcessingException.class)
    @RabbitListener(queues = {queueName})
    public void userQueueMessage(@Payload HeyteaMQBody<String> msg) {
        log.info("Recieved MessageVo Message: {}", msg);
        String data = msg.getData();
        String biz = msg.getBiz();

        if (Objects.equals(biz, "heytea.sso.account.002")) {
            OBJECT_MAPPER.readValue(data, new TypeReference<EntityChangeDTO<SfEmployeeJob>>() {});
            // TODO: 2020/10/27 处理员工账号数据变动
        }

        if (Objects.equals(biz, "heytea.sso.account.003")) {
            OBJECT_MAPPER.readValue(data, new TypeReference<EntityChangeDTO<ShopUser>>() {});
            // TODO: 2020/10/27 处理门店账号数据变动
        }
    }

}