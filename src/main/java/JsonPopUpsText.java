import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.POP;

public class JsonPopUpsText {

    public static void main(String[] args){

        String title = "开通%s";

        PopUpsText  promotions = new PopUpsText(
                title,
                "1.首%s仅%s元，到期前一天为您自动续费%s元/%s（可取消，取消后不再自动续费）；\n" +
                        "2.可在“管理自动续费”一键取消，简单方便；\n" +
                        "3.扣费前消息通知，完全透明。"

        );

        PopUpsText freetrial = new PopUpsText(
                title,
                "1.免费试用%s天，到期前一天为您自动续费%s元/%s（可取消，取消后不再自动续费）；\n" +
                        "2.可在“管理自动续费”中一键取消，简单方便；\n" +
                        "3.扣费前消息通知，完全透明"

        );

        PopUpsText normal = new PopUpsText(
                title,
                "1.到期前一天为您自动续费%s元/%s（可取消，取消后不再自动续费）；\n" +
                        "2.可在“管理自动续费”中一键取消，简单方便；\n" +
                        "3.扣费前消息通知，完全透明；"
        );

        System.out.println(JSON.toJSON(promotions));
        System.out.println(JSON.toJSON(freetrial));
        System.out.println(JSON.toJSON(normal));

    }
}
