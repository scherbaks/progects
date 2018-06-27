package model.logic;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Date;
import java.util.Random;

public class JMSSender {

    private JmsTemplate jmsTemplate;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }


    public void sendMessage() {

        getJmsTemplate().send(new MessageCreator(){
            public Message createMessage(Session session) throws JMSException {
                //create our date and value for message
                Date date = new Date();
                Random rnd = new Random(System.currentTimeMillis());
                int number = 1 + rnd.nextInt(10 - 1 + 1);

                System.out.println("The Ping sending message in queue2:  " + date + " \"My value is: " + number + "\"");
                return session.createObjectMessage(new MyMessage(number,date));
            }
        });
    }
}

