package dateUtil;

import java.util.Calendar;
import java.util.Date;

public class GetEndOfDay {

    public static void main(String[] args){

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.SECOND, -1);

        Date date = calendar.getTime();

        System.out.println(date.toString());
        System.out.println(date.getTime());
    }
}
