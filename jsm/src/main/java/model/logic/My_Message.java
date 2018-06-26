package model.logic;

import java.io.Serializable;
import java.util.Date;

public class My_Message implements Serializable{

    private static final long serialVersionUID = 7743153434255175184L;
    private Date date;
    private Integer value;

    public My_Message(){}

    public My_Message(Integer value, Date date) {
        this.date = date;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }


    public String gettoStringDate () {return getDate().toString();}

    public My_Message getmy_message() {
        return new My_Message(getValue(), getDate());
    }
}
