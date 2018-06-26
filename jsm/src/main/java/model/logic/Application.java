package model.logic;

import model.logic.My_Message;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Message;
import javax.jms.ObjectMessage;
import java.util.Date;
import java.util.Random;


public class Application {
    public static  void  main(String[] args){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config.xml");
        JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("jmstemplatetopic");
        JMSReceiver receiver = new JMSReceiver();
        JMSSender sender = new JMSSender();

        //create our dats for message
        Date date = new Date();
        Random rnd = new Random(System.currentTimeMillis());
        int number = 1 + rnd.nextInt(11 - 1 + 1);

        sender.setDate(date);
        sender.setValue(number);

        //Send message
        sender.setJmsTemplate(jmsTemplate);
        sender.sendMessage();

        //Receive message
        ObjectMessage message = (ObjectMessage) ctx.getBean("jmstemplatetopic");
        receiver.onMessage(message);

    }
}
