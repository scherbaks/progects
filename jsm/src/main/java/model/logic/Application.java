package model.logic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;
import java.util.Random;

public class Application {
    public static  void  main(String[] args){
        final Random generator = new Random();
        try{
            ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config.xml");
            JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("jmstemplate");

            //Send message
            jmsTemplate.send(new MessageCreator(){
                public Message createMessage(Session session) throws JMSException {
                    TextMessage message = session.createTextMessage();
                    message.setText(Long.toString(Math.abs(generator.nextLong()), 36));
                    return message;
                    }
            });
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
