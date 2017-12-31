package com.whp.tutorial4.routing.direct;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class Tut4Receiver {

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receiveQueue1With1(String in) throws InterruptedException {
        receive(in, 1);
    }

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receiveQueue1With2(String in) throws InterruptedException {
        receive(in, 2);
    }
    
    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receiveQueue1With3(String in) throws InterruptedException {
        receive(in, 3);
    }
    
    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public void receiveQueue2With1(String in) throws InterruptedException {
        receive(in, 1);
    }

    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public void receiveQueue2With2(String in) throws InterruptedException {
        receive(in, 2);
    }
    
    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public void receiveQueue2With3(String in) throws InterruptedException {
        receive(in, 3);
    }

    public void receive(String in, int receiver) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println("instance " + receiver + " [x] Received '" + in + "'");
        doWork(in);
        watch.stop();
        System.out.println("instance " + receiver + " [x] Done in " + 
            watch.getTotalTimeSeconds() + "s");
    }

    private void doWork(String in) throws InterruptedException {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000);
            }
        }
    }

}