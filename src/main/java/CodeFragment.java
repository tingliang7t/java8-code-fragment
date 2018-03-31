import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import jdk.nashorn.internal.objects.NativeNumber;
import jdk.nashorn.internal.runtime.JSONFunctions;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

    /*** deep flattern**/
    public static int[] deepFlattern(Object[] input){

        return Arrays.stream(input)
                .flatMapToInt( o ->{
                    if (o instanceof Object[]){
                        return Arrays.stream(deepFlattern((Object[]) o));
                    }

                    return IntStream.of((Integer)o);
                }).toArray();
    }

    /*** find diff between two colleciton ***/
    public static <T> Collection<T> difference(Collection<T> c1, Collection<T> c2){

        if ( c1 == null || c2 == null){
            return null;
        }

        return c1.stream().filter( o1->!c2.contains(o1)).collect(Collectors.toList());
    }

    /*** distinct ****/
    public static <T> List<T> distinct(List<T> list){

        if (list == null){
            return null;
        }

        return list.stream().distinct().collect(Collectors.toList());
    }

    /*** remove every Nth element ***/
    public static int[] removeEveryNthElement(int[] numbers, int n){

        if (numbers.length == 0 || numbers.length < n) {
            return new int[0];
        }

        return IntStream.range(0, numbers.length)
                .filter( i->numbers[i]%n == n-1)
                .map(i->numbers[i])
                .toArray();
    }

    /*** indexOf ***/
    public static int indexOf(int[] numbers, int target){

        if (numbers.length == 0){
            return -1;
        }

        return IntStream.range(0, numbers.length).filter(i->numbers[i] == target).findFirst().orElse(-1);

    }

}

