package com.example.yanyun.Utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.yanyun.Model.Bean.Json.BaseJson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * description ： 工具类：用于访问网络
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/18 20:18
 */
public class Net<T extends BaseJson> {

    /***
     * 将输入流转化为字符串
     * @param inputStream   输入流
     * @return 字符串
     */
    public static String StreamToString(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String tempLine;
        try {
            while ((tempLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(tempLine).append("\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }


    /***
     * 网络访问get(无参数)
     * @param url 网址
     * @param handler   传入handler,message代号为0
     * @param jsonBean  传入一个对应JsonBean的实体类进来
     */
    public void doGet(String url, Handler handler, T jsonBean) {
        new Thread(new Runnable() {
            String resultStr = "";

            @Override
            public void run() {

                try {
                    URL Url = new URL(url);
                    HttpURLConnection connection = (HttpURLConnection) Url.openConnection();
                    //配置连接参数
                    connection.setConnectTimeout(5 * 1000);
                    connection.setRequestMethod("GET");
                    //建立连接
                    connection.connect();

                    InputStream inputStream = connection.getInputStream();
                    resultStr = StreamToString(inputStream);
                    Log.d("ld", resultStr);

                    T result = jsonBean.decodeJson(resultStr);

                    Message message = new Message();
                    message.what = 0;
                    message.obj = result;
                    handler.sendMessage(message);


                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    /***
     * 网络访问get(有参数)
     * @param baseurl 基础url
     * @param map   参数map
     * @param handler   传入handler,message代号为0
     * @param jsonBean  传入一个对应JsonBean的实体类进来
     */
    public void doGet(String baseurl, HashMap<String, String> map, Handler handler, T jsonBean) {
        StringBuilder stringBuilder = new StringBuilder(baseurl).append("?");
        for (String key : map.keySet()) {
            stringBuilder.append(key).append("=").append(map.get(key)).append("&");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);//删除最后一个&
        doGet(stringBuilder.toString(), handler, jsonBean);
    }


    /***
     * 网络访问POST
     * @param url   网址
     * @param hashMap   参数
     * @param handler   传入handler,message代号为1
     * @param jsonBean  传入一个对应JsonBean的实体类进来
     */
    public void doPost(String url, HashMap<String, String> hashMap, Handler handler, T jsonBean) {
        new Thread(new Runnable() {
            String resultStr = "";

            @Override
            public void run() {
                try {
                    URL Url = new URL(url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) Url.openConnection();
                    //配置连接属性
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setConnectTimeout(4 * 1000);
                    //连接
                    httpURLConnection.connect();

                    //拼接POST数据
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String key : hashMap.keySet()) {
                        stringBuilder.append(key).append("=").append(hashMap.get(key)).append("&");
                    }
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);//删除最后一个$


                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(stringBuilder.toString().getBytes());

                    InputStream inputStream = httpURLConnection.getInputStream();
                    resultStr = StreamToString(inputStream);

                    Log.d("ld", resultStr);

                    //将String格式的Json转化为JsonBean类
                    T result = jsonBean.decodeJson(resultStr);
                    Message message = new Message();
                    message.what = 1;
                    message.obj = result;
                    handler.sendMessage(message);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

}
