package model.logic;

import java.io.Serializable;
import java.util.Date;

public class MyMessage implements Serializable{

    private static final long serialVersionUID = 7743153434255175184L;
    private Date date;
    private Integer value;

    public MyMessage(Integer value, Date date) {
        this.date = date;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
    public Date getDate() {
        return date;
    }

    public MyMessage getmy_message() {
        return new MyMessage(getValue(), getDate());
    }
}
