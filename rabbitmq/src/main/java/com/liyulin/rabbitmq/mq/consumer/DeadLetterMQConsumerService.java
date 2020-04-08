package com.liyulin.rabbitmq.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.liyulin.rabbitmq.consts.MqConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DeadLetterMQConsumerService {

	@RabbitListener(queues = MqConstants.DeadLetter.REDIRECT_QUEUE)
	public void consumerAmqp(String msg) {
		log.info("receiver delay msg:" + msg);
	}

}