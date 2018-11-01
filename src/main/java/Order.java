import com.sun.tools.corba.se.idl.constExpr.Or;

import java.util.Comparator;

public class Order implements Comparable<Order> {

    private int value;

    public Order(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Order o){

        if (value == o.getValue())
            return 0;

        return value > o.getValue() ? -1 : 1;
    }
}
