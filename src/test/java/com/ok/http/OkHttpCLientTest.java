package com.ok.http;

import com.alibaba.fastjson.JSON;
import com.ok.http.entity.ModelObj;
import com.ok.http.util.HttpClient;
import org.junit.jupiter.api.Test;


public class OkHttpCLientTest {

    HttpClient client = new HttpClient();

    @Test
    public void sendAndRecieve() throws Exception {

        byte[] data = new byte[]{};

        ModelObj obj = ModelObj.builder().data(data).no(1).build();
        String json = JSON.toJSONString(obj);

        ModelObj resp  = client.doHttpPost(json);
        System.out.println("Response from Model : "+resp);

        assert resp != null;


    }
}
