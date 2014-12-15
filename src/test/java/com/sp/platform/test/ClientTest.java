package com.sp.platform.test;

import com.alibaba.fastjson.JSON;
import com.sp.platform.gateway.request.MnSmsRequest;
import com.sp.platform.gateway.response.MnSmsResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
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

import javax.ws.rs.core.MediaType;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: mopdzz
 * Date: 14-12-13
 * Time: 上午11:31
 * To change this template use File | Settings | File Templates.
 */
public class ClientTest {
    @Test
    public void testPostJson() {
        try {
            Client client = Client.create();
            URI url = new URI("http://localhost:8080/rest/mn/sms");
            System.out.println(url);
            WebResource resource = client.resource(url);
            MnSmsRequest request = new MnSmsRequest();
            request.setLinkId("linkId");
            request.setServiceId("serviceId");
            String response = resource.entity(request).type(MediaType.APPLICATION_JSON).post(String.class);
            System.out.println("return:" + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetJson() {
        try {
            Client client = Client.create();
            URI url = new URI("http://localhost:8080/mn/sms?linkId=getLinkId&serviceId=getServiceid");
            System.out.println(url);
            WebResource resource = client.resource(url);
//            MnSmsResponse response = resource.type(MediaType.APPLICATION_JSON).get(MnSmsResponse.class);
//            System.out.println(response);
            System.out.println(resource.type(MediaType.APPLICATION_JSON).get(String.class));

            HttpClient httpClient = new DefaultHttpClient();
            HttpGet get = new HttpGet("http://localhost:8080/mn/sms?linkId=getLinkId&serviceId=getServiceid");
            HttpResponse response = httpClient.execute(get);
            System.out.println(IOUtils.toString(response.getEntity().getContent()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPostJson2() throws Exception {

        Map<String, Object> map = new TreeMap<String, Object>();
        map.put("fmsgtype", "1");
        map.put("forgaddr", "13552922122");
        map.put("fdestaddr", "10651234");
        map.put("ffeeterminal", "13552922122");
        map.put("fcontent", "wos20141103004501629Pux4834");
        map.put("fgatewayid", "2");
        map.put("fserviceid", "1066");
        map.put("fservicecode", "tqyb");
        map.put("ffeetypeid", "2");
        map.put("ffeecode", "200");
        map.put("fgatewayid", "2");
        map.put("flinkid", "wo20141103004501629Pux4834");
        map.put("fsubmitstatus", "0");

        String body = JSON.toJSONString(map);
        System.out.println(body);
        HttpPost post = new HttpPost("http://123.57.41.251/rest/mn/sms");
        StringEntity se = new StringEntity(body);
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8"));

        post.addHeader("Content-Type", MediaType.APPLICATION_JSON);
        post.setEntity(se);
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse httpResponse = httpClient.execute(post);
        System.out.println(String.valueOf(httpResponse.getStatusLine().getStatusCode()));
        System.out.println(IOUtils.toString(httpResponse.getEntity().getContent()));
    }

    @Test
    public void testPostXML2() throws Exception {
        String body = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><mnSmsRequest><serviceId>Success</serviceId><linkId>200</linkId></mnSmsRequest>";
        System.out.println(body);
        HttpPost post = new HttpPost("http://localhost:8080/mn/sms");
        StringEntity se = new StringEntity(body);
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/xml;charset=UTF-8"));

        post.addHeader("Content-Type", MediaType.APPLICATION_XML);
        post.setEntity(se);
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse httpResponse = httpClient.execute(post);
        System.out.println(String.valueOf(httpResponse.getStatusLine().getStatusCode()));
        System.out.println(IOUtils.toString(httpResponse.getEntity().getContent()));
    }
}
