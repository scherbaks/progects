package model.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import javax.jms.*;
import javax.jms.ObjectMessage;
import java.io.Serializable;

public class PongReceiver implements MessageListener, Serializable {

    @Autowired
   // @Qualifier("senqueue")//
   // @Resource(name = "sendqueue")
    PongSender sender;

    public void onMessage(Message message) {
        Thread receiver = Thread.currentThread();
        ObjectMessage my_message = (ObjectMessage)message;
        System.out.println("Thread.getIdup=" + receiver.getId());
        try{
            System.out.println("Thread.getIdtry=" + receiver.getId());
            MyMessage recievemessage = (MyMessage) my_message.getObject();
            System.out.println("The Pong following message in topic: " + recievemessage.getDate() + " \"Your value is: " + recievemessage.getValue() + "\"");
            System.out.println("Thread.getId=" + receiver.getId());

            sender.sendMessage();

//          Thread.sleep(1000000000);
        } catch (JMSException e) {
            e.printStackTrace();
        }/* catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}

