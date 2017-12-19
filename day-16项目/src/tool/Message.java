package tool;

import net.sf.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Message {
    @Test
    public static void Test() throws IOException {
            URL url = new URL(Contants.ADDRESS_FIRST);
            URLConnection conm = url.openConnection();
            InputStream is = conm.getInputStream();

            byte[] buff = new byte[1024*1024];
            StringBuffer sb = new StringBuffer();
            int len = 0;
            while((len=is.read(buff)) != -1){
                StringBuffer append = sb.append(new String(buff, 0, len));
            }

            JSONObject jsonObject =   JSONObject.fromObject(sb.toString());
            MessageEntity messageEntity = (MessageEntity) JSONObject.toBean(jsonObject,MessageEntity.class);
            System.out.println("第一名分数: " + messageEntity.getScore() + "第一名用户为" + messageEntity.getNickname());
            is.close();
        }
}