import java.util.Calendar;

public class Cal {

    public static void main(String[] args){
        int year = 2018;
        int month = 5;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1, 0, 0);

        System.out.println(calendar.getTimeInMillis());

        calendar.set(year, month, 0, 0 ,0);

        System.out.println(calendar.getTimeInMillis());
    }
}
