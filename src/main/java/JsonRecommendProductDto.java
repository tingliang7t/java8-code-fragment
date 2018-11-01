import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Maps;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.xml.internal.xsom.XSWildcard;

import java.util.*;

public class JsonRecommendProductDto {

    public static void main(String[] args){

        String url = "http://fdfs.xmcdn.com//group44/M08/5B/71/wKgKkVsGNA7x0RcqAAWllwUeURY932.png";

        Map<Integer, RecommendProductDto> amap = Maps.newHashMap();
        RecommendProductDto aOther = new RecommendProductDto(1010500100000120708L, url);
        RecommendProductDto aMain = new RecommendProductDto(1010500100000120708L, url);
        RecommendProductDto aActivity = new RecommendProductDto(1010500100000120712L, url);

        amap.put(0, aOther);
        amap.put(1, aMain);
        amap.put(2, aActivity);

        Map<Integer, RecommendProductDto> iosMap = Maps.newHashMap();
        RecommendProductDto iOther = new RecommendProductDto(1010500100000120723L, url);
        RecommendProductDto iMain = new RecommendProductDto(1010500100000120723L, url);
        RecommendProductDto iActivity = new RecommendProductDto(1010500100000120516L, url);

        iosMap.put(0, iOther);
        iosMap.put(1, iMain);
        iosMap.put(2, iActivity);

        System.out.println(JSON.toJSONString(amap));

        System.out.println(JSON.toJSONString(iosMap));
    }

}
