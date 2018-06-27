package model.logic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;

public class Pong {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config.xml");
        JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("jmstemplatequeue");
        PongSender sender = new PongSender();
        sender.setJmsTemplate(jmsTemplate);
        PongReceiver receiver = new PongReceiver();
        receiver.setSender(sender);
        }
}