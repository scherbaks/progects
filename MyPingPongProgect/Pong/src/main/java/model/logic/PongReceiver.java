package model.logic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.*;
import javax.jms.ObjectMessage;
import java.io.Serializable;

public class PongReceiver implements MessageListener, Serializable {
    public PongReceiver() {
    }

    public void onMessage(Message message) {
        ObjectMessage my_message = (ObjectMessage)message;
        try{
            message.acknowledge();
                MyMessage recievemessage = (MyMessage) my_message.getObject();
                System.out.println("The Pong following message in queue: " + recievemessage.getDate() + " \"Your value is: " + recievemessage.getValue() + "\"");

            Thread.sleep(5000);
            ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config.xml");
            PongSender sender = (PongSender) ctx.getBean("sendqueue");
            sender.sendMessage();

        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

