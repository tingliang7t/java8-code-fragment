package dateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormator {

    private static final String dateFormat = "yyyy-MM-dd";

    public static void main(String[] args){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
