import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class CodeFragment {

    /****** gcd *****/
    public static OptionalInt gcd(int[] numbers){
        return Arrays.stream(numbers)
                .reduce((a,b)->gcd(a,b));

    }

    private static int gcd(int a, int b){

        if (b == 0){
            return a;
        }
        return gcd(b, a%b);
    }

    /*** concat ****/
    public static <T> T[] concat(T[] first, T[] second){

        return Stream.concat(
                Stream.of(first),
                Stream.of(second)
        ).toArray( i->{
            System.out.println(i);
            return (T[])Arrays.copyOf(new Object[0], i, first.getClass());
        });
    }

    /*** count Occurrence ****/
    //@ bug if  value is null
    public static <T> long countOccurrence(T[] lists, Object value){

        if (null == lists || lists.length == 0){
            return 0;
        }

        return Arrays.stream(lists)
                     .filter( e->lists.equals(value))
                     .count();
    }

}
