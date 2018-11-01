import java.math.BigDecimal;

public class BigDecimalEquals {

    public static void main(String[] args){

        BigDecimal bigDecimal = new BigDecimal(0.00);
        BigDecimal bigDecimal1 = new BigDecimal(0);

        System.out.println(bigDecimal.equals(bigDecimal1));
    }
}
