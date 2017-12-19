package tool;

import net.sf.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Phone {

    @Test
    public static void Test(String phoneNum) throws IOException {

        URL url = new URL("http://api.k780.com/?app=phone.get&phone="+phoneNum + "&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json");
        URLConnection conm = url.openConnection();
        InputStream is = conm.getInputStream();

        byte[] buff = new byte[1024*1024*102];
        StringBuffer sb = new StringBuffer();
        int len = 0;
        while((len=is.read(buff)) != -1){
            StringBuffer append = sb.append(new String(buff, 0, len));
        }

        JSONObject jsonObject =   JSONObject.fromObject(sb.toString());
        PhoneNum address = (PhoneNum) JSONObject.toBean(jsonObject,PhoneNum.class);
        PhoneNum.ResultBean resultBean = address.getResult();

        System.out.println("地址: " + resultBean.getAtt()  + "   ;营业厅: " +resultBean.getOperators());
        is.close();
    }
}
