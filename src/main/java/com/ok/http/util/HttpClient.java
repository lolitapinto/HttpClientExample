package com.ok.http.util;


import com.alibaba.fastjson.JSON;
import com.ok.http.entity.ModelObj;
import lombok.extern.log4j.Log4j2;
import okhttp3.*;

import java.io.IOException;

@Log4j2
public class HttpClient {


    OkHttpClient httpClient = new OkHttpClient();

    public ModelObj doHttpPost(String json) throws Exception {

        String url = "http://10.111.137.201:4545/test";
        log.debug("post to model api {}", url);

//        log.info("Json Body  : {}", json);
        RequestBody body = RequestBody.create(json,MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (response.body() == null) {
                log.error("Got empty result from model ");
                throw new Exception("no response from model");
            }
            return JSON.parseObject(response.body().string(), ModelObj.class);
        } catch (IOException e) {
            log.error("Exception occurred connecting to model", e);
            throw new Exception("no response from model");
        }
    }

}
