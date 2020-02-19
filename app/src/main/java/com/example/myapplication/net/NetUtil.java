package com.example.myapplication.net;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.google.gson.internal.bind.TypeAdapters.URL;

/**
 * @author: 王重阳
 * @date: 2020/1/7
 */
public class NetUtil  {
    private static  NetUtil instance;
    private NetUtil (){}

    public static NetUtil getInstance() {
        if (instance==null) {
            instance = new NetUtil();
        }
        return instance;
    }

    //doGet方法
    public  void  doGet(final String path, final CallBack callBack){
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
                        Log.d("xx", "doInBackground: "+json);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (!TextUtils.isEmpty(s)) {
                    callBack.oncheng(s);
                }else {
                    callBack.onbai("请求失败");
                }
            }
        }.execute(path);
    }
    public  void  imagedoGet(final String imagepath, final ImageView imageView){
        new AsyncTask<String, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... strings) {

                try {
                    URL url = new URL(imagepath);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode==200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                        Log.d("xx", "doInBackground: "+bitmap);
                        return bitmap;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (bitmap==null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        }.execute(imagepath);
    }
    //创建接口
    public  interface  CallBack{
        void oncheng(String json);
        void onbai(String msg);
    }

}
