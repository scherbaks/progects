package model.logic;

public class Application {
    public static void main(String[] args) {

        JMSSender sender = new JMSSender();
        sender.sendMessage();

    }
}
