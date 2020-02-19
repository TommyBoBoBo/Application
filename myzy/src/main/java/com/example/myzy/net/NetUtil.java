package com.example.myzy.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.myzy.app.App;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author: 王重阳
 * @date: 2020/1/10
 */
public class NetUtil {
    //单例
    private static  NetUtil instance;
    private NetUtil(){};

    public static NetUtil getInstance() {
        if (instance ==null) {
            instance = new NetUtil();
        }
        return instance;
    }

    //doGet方法

    public void  doGet(final String path, final CallBack callBack){
        boolean net = net();
        if (!net) {
            Toast.makeText(App.context, "请检查网络", Toast.LENGTH_SHORT).show();
        }
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
                        return json;

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

    public void  imagedoGet(final String imagepath, final ImageView imageView){
        boolean net = net();
        if (!net) {
            Toast.makeText(App.context, "请检查网络", Toast.LENGTH_SHORT).show();
        }

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
                        return bitmap;

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                if (bitmap!=null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        }.execute(imagepath);


    }


  public boolean net(){
      ConnectivityManager systemService = (ConnectivityManager) App.context.getSystemService(Context.CONNECTIVITY_SERVICE);
      NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
      if (activeNetworkInfo==null) {
          boolean available = activeNetworkInfo.isAvailable();
          return available;
      }
      return false;

  }


    public interface CallBack{
        void oncheng(String json);
        void onbai(String msg);

    }

}
