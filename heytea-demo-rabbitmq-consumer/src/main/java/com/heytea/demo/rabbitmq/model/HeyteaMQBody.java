package com.heytea.demo.rabbitmq.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * MQ 消息体统一格式
 * 
 * @author huahouye xuzhimin@heytea.com
 * @date 2019/12/26
 */
@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeyteaMQBody<T> {

    @SuppressWarnings("rawtypes")
    public static final HeyteaMQBody DEFAULT_MQ_BODY = new DefaultHeyteaMQBody();

    /**
     * 业务编码
     */
    private String biz;

    /**
     * 唯一事件 id，幂等性保证，全局 ID 或者 uuid 等
     */
    private String uid;

    /**
     * 时间戳，单位毫秒 EpochMilli
     */
    private long dateTime;

    /**
     * 数据
     */
    private T data;

    public static <T> HeyteaMQBody<T> build(String biz, T data) {
        // @formatter:off
        return new HeyteaMQBody<T>()
            .setBiz(biz)
            .setUid(UUID.randomUUID().toString())
            .setDateTime(System.currentTimeMillis())
            .setData(data);
        // @formatter:on
    }

    public static <T> HeyteaMQBody<T> build(String biz, String uid, T data) {
        // @formatter:off
        return new HeyteaMQBody<T>()
            .setBiz(biz)
            .setUid(uid)
            .setDateTime(System.currentTimeMillis())
            .setData(data);
        // @formatter:on
    }

    public static <T> HeyteaMQBody<T> build(String biz, String uid, LocalDateTime dateTime, T data) {
        // @formatter:off
        Assert.isNull(dateTime, " date time must not null");
        return new HeyteaMQBody<T>()
            .setBiz(biz)
            .setUid(uid)
            .setDateTime(dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli())
            .setData(data);
        // @formatter:on
    }

    @Getter
    private static final class DefaultHeyteaMQBody<T> extends HeyteaMQBody<T> {
        private final String biz = HeyteaCodeConstant.NS_BIZ.NAME;
        private final String uid = UUID.randomUUID().toString();
        private final long dateTime = System.currentTimeMillis();
        private final T data = null;
    }

}
