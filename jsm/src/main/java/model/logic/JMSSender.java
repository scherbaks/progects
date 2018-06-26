package model.logic;

import model.logic.My_Message;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.ObjectMessage;
import java.util.Date;

public class JMSSender {

    private JmsTemplate jmsTemplate;
    private Date date;
    private Integer value;

    public JMSSender() {
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public void setValue(Integer value) {
        this.value = value;
    }
    public Integer getValue() {
        return value;
    }
    public Date getDate() {
        return date;
    }

    public My_Message my_message = new My_Message(getValue(),getDate());

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

//  public My_Message getMy_Message() {return my_message;}
    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }


    public void sendMessage() {
        getJmsTemplate().send(new MessageCreator(){
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(new My_Message(getValue(),getDate()));
                //ObjectMessage message = session.createObjectMessage(my_message);
                //message.setObjectProperty("destinationtopic", my_message.getValue());
                //return message;
            }
        });
    }
}

