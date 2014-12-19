package com.sp.platform.test;

import com.alibaba.fastjson.JSON;
import com.sp.platform.domain.User;
import com.sp.platform.gateway.request.MnSmsRequest;
import com.sp.platform.service.UserService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.core.MediaType;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: mopdzz
 * Date: 14-12-17
 * Time: 下午11:12
 * To change this template use File | Settings | File Templates.
 */
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void testGetUser() {
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet get = new HttpGet("http://localhost:8080/rest/user/get?id=29");
            HttpResponse response = httpClient.execute(get);
            System.out.println(IOUtils.toString(response.getEntity().getContent()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSaveUser() throws Exception {
        Map<String, Object> map = new TreeMap<String, Object>();
        map.put("name", "name");
        map.put("passwd", "passwd");

        String body = JSON.toJSONString(map);
        System.out.println(body);
        HttpPost post = new HttpPost("http://localhost:8080/rest/user/save");
        StringEntity se = new StringEntity(body);
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8"));
        post.addHeader("Content-Type", MediaType.APPLICATION_JSON);
        post.setEntity(se);
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse httpResponse = httpClient.execute(post);
        System.out.println(String.valueOf(httpResponse.getStatusLine().getStatusCode()));
        System.out.println(IOUtils.toString(httpResponse.getEntity().getContent()));
    }
}
