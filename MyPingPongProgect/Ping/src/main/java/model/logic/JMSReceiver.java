package model.logic;

import javax.jms.ObjectMessage;
import javax.jms.*;
import java.io.Serializable;

public class JMSReceiver implements MessageListener, Serializable {
    public JMSReceiver() {
    }

    public void onMessage(Message message) {
        ObjectMessage my_message = (ObjectMessage)message;

        try {
            my_message.acknowledge();
            MyMessage recievermessage = (MyMessage)my_message.getObject();
            System.out.println("The Ping following message in queue: " + recievermessage.getDate() + " \"Your value is: " + recievermessage.getValue() + "\"\n\"Ping-Pong complite\"\n");

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
