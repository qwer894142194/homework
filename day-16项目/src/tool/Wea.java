package tool;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.net.URLConnection;
import net.sf.json.JSONObject;

public class Wea {

    @Test
    public void Test(String city) throws IOException {
        URL url = new URL("http://api.map.baidu.com/telematics/v3/weather?location="+city+ "&output=json&ak=6tYzTvGZSOpYB5Oc2YGGOKt8"
        );
        URLConnection conm = url.openConnection();
        InputStream is = conm.getInputStream();

        byte[] buff = new byte[1024*1024];

        int len = is.read(buff);

        String result = new String(buff
                ,0,len);

        JSONObject   jsonObject =   JSONObject.fromObject(result);
        Weather weather = (Weather) JSONObject.toBean(jsonObject,Weather.class);
        System.out.println(weather.getResults());
        is.close();
    }
}
