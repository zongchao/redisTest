package com.neko.queue;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by ssjk on 2016/11/14.
 */
public class MessageQueueListener implements MessageListener {

    private RedisTemplate redisTemplate;

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println(123);
    }
}
