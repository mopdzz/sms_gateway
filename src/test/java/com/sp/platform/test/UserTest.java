package com.sp.platform.test;

import com.sp.platform.domain.User;
import com.sp.platform.gateway.request.MnSmsRequest;
import com.sp.platform.service.UserService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.core.MediaType;
import java.net.URI;

/**
 * Created with IntelliJ IDEA.
 * User: mopdzz
 * Date: 14-12-17
 * Time: 下午11:12
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserTest {
    @Autowired
    private UserService userService;
    @Test
    public void testPostJson() {
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet get = new HttpGet("http://localhost:8080/user/get?id=1");
            HttpResponse response = httpClient.execute(get);
            System.out.println(IOUtils.toString(response.getEntity().getContent()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testGetUser() {
        long start = System.currentTimeMillis();
        User user = userService.get(1);

        System.out.println(user); // 显示调用结果
    }
}
