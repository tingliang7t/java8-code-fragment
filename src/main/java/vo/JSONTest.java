package vo;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xerces.internal.dom.PSVIDOMImplementationImpl;

public class JSONTest {

    public static void main(String[] args){

        String jsonString = "{\"id\":1,\"configs\":[{\"id\":1,\"name\":\"非会员-新用户-有促销资格\",\"resource\":{\"id\":1,\"type\":2,\"value\":\"http://fdfs.xmcdn.com//group44/M0A/69/7B/wKgKkVsRE5ejo9xBAACUXOZ2muE532.png\"},\"comment\":\"图片尺寸：750*200\",\"actions\":[{\"id\":1,\"type\":1,\"value\":\"m.test.ximalaya.com\"},{\"id\":2,\"type\":2,\"value\":\"iting:type=1&album_id=99799\"}]}]}";

        PositionConfigVo positionConfigVo = JSON.parseObject(jsonString, PositionConfigVo.class);

        System.out.println(positionConfigVo.getName() + ":" + positionConfigVo.getGroupId());
    }
}
