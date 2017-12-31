package com.whp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.whp.tutorial4.routing.direct.Tut4Receiver;
import com.whp.tutorial4.routing.direct.Tut4Sender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRabbitMqHelloApplicationTests {
	
	@Autowired
	private Tut4Sender routingSender;
	
	@Autowired
	private Tut4Receiver routingReceiver;

//	@Test
//	public void contextLoads() {
//	}
	
	@Test
	public void routingSender() throws Exception {
		routingSender.send();
	}
	
	

}
