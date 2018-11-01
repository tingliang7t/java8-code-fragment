import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;

public class JSONTest {

    public static void main(String[] args){

        List<Integer> ids = Lists.newArrayList();

        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);

        System.out.println(JSON.toJSONString(ids));
    }
}
