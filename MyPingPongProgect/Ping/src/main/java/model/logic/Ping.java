package model.logic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import java.lang.Thread;

public class Ping {
    public static  void  main(String[] args){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config.xml");
        JMSSender sender = (JMSSender) ctx.getBean("sendqueue");

        do {
            try {
                sender.sendMessage();
                Thread.sleep(10000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (true);
    }
}

