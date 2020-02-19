package com.example.myyklx.net;

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

import com.example.myyklx.app.App;
import com.example.myyklx.base.BaseFragment;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author: 王重阳
 * @date: 2020/2/15
 */
public class NetUtil  {
    private static NetUtil instance;
    private NetUtil(){}

    public static NetUtil getInstance() {
        if (instance==null) {
            instance = new NetUtil();
        }
        return instance;
    }
//doGet方法
public void doGet(final String path, final CallBack callBack){
        //判断网络
   /* boolean net = net();
    if (!net) {
        Toast.makeText(App.context, "网络异常", Toast.LENGTH_SHORT).show();
    }*/
    new AsyncTask<String, Void, String>() {
        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(path);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setRequestMethod("GET");
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode==200) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    int len = -1;
                    byte[] bytes = new byte[1024];
                    StringBuffer stringBuffer = new StringBuffer();
                    while ((len = inputStream.read(bytes))!=-1){
                        stringBuffer.append(new String(bytes,0,len));
                    }
                    //关流
                    inputStream.close();
                    String json = stringBuffer.toString();
                    Log.d("xxx", "doInBackground: "+json);
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
            if (callBack!=null) {
                callBack.oncheng(s);
            }else {
                callBack.onbai("数据异常");
            }
        }
    }.execute(path);

}

    //doGet方法
    public void ImageGet(final String imagepath, final ImageView imageView){
        //判断网络
    /*    boolean net = net();
        if (!net) {
            Toast.makeText(App.context, "网络异常", Toast.LENGTH_SHORT).show();
        }*/
        new AsyncTask<String, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... strings) {
                try {
                    URL url = new URL(imagepath);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setRequestMethod("GET");
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
            protected void onPostExecute(Bitmap bitmap ) {
                super.onPostExecute(bitmap);
                if (bitmap!=null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        }.execute(imagepath);


    }




    //判断网络
    private boolean net(){
        ConnectivityManager systemService = (ConnectivityManager) App.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        if (activeNetworkInfo!=null) {
            boolean available = activeNetworkInfo.isAvailable();
            return available;
        }
        return false;
    }

    //创建接口
    public  interface  CallBack{
        void  oncheng(String json);
        void  onbai(String msg);

    }
}
