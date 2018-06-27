package model.logic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.JmsException;

public class Pong {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config.xml");
        PongSender sender = (PongSender) ctx.getBean("sendqueue");
//      PongReceiver receiver = (PongReceiver) ctx.getBean("jmsContainertopic");
/*
            try{
                sender.sendMessage();
            } catch (JmsException e) {
                e.printStackTrace();
            }
*/
        }
}


