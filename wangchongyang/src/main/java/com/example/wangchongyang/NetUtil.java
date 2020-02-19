package com.example.wangchongyang;

import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author: 王重阳
 * @date: 2020/1/11
 */
public class NetUtil {
    private static NetUtil instance;
    private NetUtil(){}

    public static NetUtil getInstance() {
        if (instance == null) {
            instance=new NetUtil();

        }
        return instance;
    }


    public void  doGet(final String path, CallBack callBack){

        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {
                try {
                    URL url = new URL(path);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode==200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        int len = -1;
                        byte[] bytes = new byte[1024];
                        StringBuffer stringBuffer = new StringBuffer();
                        while ((len = inputStream.read(bytes))!=-1){
                            String s = new String(bytes, 0, len);
                            stringBuffer.append(s);

                        }
                        String json = stringBuffer.toString();


                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
            }
        }.execute(path);

    }


    public interface CallBack{
        void oncheng(String json);
        void onbai(String msg);

    }
}
