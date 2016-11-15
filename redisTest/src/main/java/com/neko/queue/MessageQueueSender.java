package com.neko.queue;


import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

/**
 * Created by ssjk on 2016/11/14.
 */
public class MessageQueueSender {

    private RedisTemplate<String, Object> redisTemplate;


    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }


    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    public void sendMessage(String channel, Serializable message) {
        redisTemplate.convertAndSend(channel, message);
    }
}
