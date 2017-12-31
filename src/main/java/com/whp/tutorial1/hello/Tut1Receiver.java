package com.whp.tutorial1.hello;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener(queues = "hello")
public class Tut1Receiver {
	
	@Autowired
	private Queue queue;
	
	@RabbitHandler
    public void receive(String in) {
		
		System.out.println("Queue:"+queue.getName());
		if(in == null) {
			System.out.println("There is no any payload from queue:"+queue.getName());
		}else {
			System.out.println(" [x] Received '" + in + "'");
		}
        
    }

}
