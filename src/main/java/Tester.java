import com.alibaba.fastjson.JSON;
import dto.AdDto;

import java.util.ArrayList;
import java.util.List;

public class Tester {

    public static void main(String[] args){

        AdDto adDto1 = new AdDto(
               "http://fdfs.xmcdn.com//group43/M07/A6/52/wKgKklsT3OiBI9RZAACm8zelev0045.png",
                "iting://open?msg_type=13&album_id=11549955&_ka=1",
                "http://m.ximalaya.com/95528803/album/11549955/"
        );

        AdDto adDto2 = new AdDto(
                "http://fdfs.xmcdn.com//group19/M03/14/EE/wKgJK1rr1hGBFaauAACf3GiyC-s107.png",
                "iting://open?msg_type=13&album_id=6294413&_ka=1",
                "http://m.ximalaya.com/69149360/album/6294413"

        );

        AdDto adDto3 = new AdDto(
                "http://fdfs.xmcdn.com//group44/M08/A7/16/wKgKkVsT4FfS4FzjAACkcXUmJZY251.png",
                "http://m.ximalaya.com/69149360/album/6294413",
                "http://m.ximalaya.com/69149360/album/6294413"
        );

        List<AdDto> adDtos = new ArrayList<>();
        adDtos.add(adDto1);
        adDtos.add(adDto2);
        adDtos.add(adDto3);
        System.out.println(JSON.toJSONString(adDtos));
    }
}
