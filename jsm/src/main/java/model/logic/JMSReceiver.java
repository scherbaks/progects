package model.logic;

import model.logic.My_Message;

import org.springframework.jms.core.MessageCreator;

import javax.jms.ObjectMessage;
import javax.jms.*;
import java.io.Serializable;

public class JMSReceiver implements MessageListener, Serializable {
    public JMSReceiver() {
    }

    public void onMessage(Message message) {
        ObjectMessage my_message = (ObjectMessage)message;
        try {
            message.acknowledge();

            System.out.println("Pong the following message: " + my_message.getObject());
            My_Message recievermessage = new My_Message(my_message.getObject())
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
