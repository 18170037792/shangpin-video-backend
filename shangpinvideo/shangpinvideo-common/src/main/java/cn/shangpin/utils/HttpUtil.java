package cn.shangpin.utils;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by qujie on 2018/11/13
 * http工具类
 * */
public class HttpUtil {

    /**
     * Get请求连接
     * */
    public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException {
        JSONObject jsonObject=null;
        /**
         * 初始化http实例
         * */
        DefaultHttpClient client=new DefaultHttpClient();
        /**
         * 发送GET请求
         * */
        HttpGet httpGet=new HttpGet(url);
        /**
         * 执行get请求，返回响应结果
         * */
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if(entity!=null){
            /**
             * 转换为json格式
             * */
            String result = EntityUtils.toString(entity,"UTF-8");
            jsonObject = JSONObject.fromObject(result);
        }
        /**
         * 释放连接
         * */
        httpGet.releaseConnection();
        return jsonObject;
    }
}
