package urlencode;

import java.net.URLEncoder;

public class EncodeTest {

    public static void main(String[] args){

        String url = "http://m.test.ximalaya.com/activity-checkin/product/page";

        try {
            String encodedUrl = URLEncoder.encode(url, "UTF-8");

            if (encodedUrl.startsWith("http")){
                System.out.println(encodedUrl);
                System.out.println(true);
            }
        }catch (Exception e){

        }
    }
}
