import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import jdk.nashorn.internal.objects.NativeNumber;
import jdk.nashorn.internal.runtime.JSONFunctions;

import java.math.BigDecimal;
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



    public static void main(String[] args){

        Map<Integer, List<Number>> data = Maps.newHashMap();

        data.put(1, Arrays.asList(11438153,4345263,6222578,5318395,7368509,8262842,11488945,5391331,10817293,9431141));
        data.put(2, Arrays.asList(6921828,11357733,9742429,6242373,12709451,6809101,8980905));
        data.put(3, Arrays.asList(8083273));
        data.put(4, Arrays.asList(13538117,13552619,9444174,11540839,13552375,13634707,6345511,5848755,6371614));
        data.put(5, Arrays.asList(4854448,8274153,5652948));

        String jsonString = JSON.toJSONString(data);
        System.out.println(jsonString);

        Map<Integer, List<Long>> idToAlbumIdMap = JSON.parseObject(jsonString, Map.class);

        System.out.println(idToAlbumIdMap.get(1).get(0));

        return;

    }

}

