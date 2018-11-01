import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUtil {

    public static void main(String[] args){
        Date d1 = new Date(1514736000000L);
        Date d2 = new Date(1509209600000L);

        long dat = ChronoUnit.DAYS.between(d1.toInstant(), d2.toInstant());

        System.out.println(dat);


    }
}
