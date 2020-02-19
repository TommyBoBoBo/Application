package com.example.my210zyy.net;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.my210zyy.app.App;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author: 王重阳
 * @date: 2020/2/14
 */
public class NetUtil  {
    private static final String TAG = "NetUtil";
    private static NetUtil instance;
    public NetUtil(){};

    public static NetUtil getInstance() {
        instance = new NetUtil();
        return instance;
    }


    public void doGet(final String path, final CallBack callBack){
        boolean pd = pd();
        if (!pd){
            Toast.makeText(App.context, "网络错误", Toast.LENGTH_SHORT).show();
        }
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {
                try {
                    URL url = new URL(path);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setRequestMethod("GET");
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200){
                        InputStream inputStream = httpURLConnection.getInputStream();
                        int len = -1;
                        byte[] bytes = new byte[1024];
                        StringBuffer stringBuffer = new StringBuffer();
                        while ((len = inputStream.read(bytes))!=-1){
                            stringBuffer.append(new String(bytes,0,len));
                        }
                        inputStream.close();
                        String json = stringBuffer.toString();
                        Log.d(TAG, "doInBackground: "+json);
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
                if (callBack!=null){
                    callBack.onCg(s);
                }else {
                    callBack.onSb("网络异常");
                }
            }
        }.execute(path);
    }
    /**
     * 图片
     */
    @SuppressLint("StaticFieldLeak")
    public void TuPian(final String imagePath, final ImageView imageView){
        boolean pd = pd();
        if (!pd){
            Toast.makeText(App.context, "网络异常", Toast.LENGTH_SHORT).show();
        }
        new AsyncTask<String, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... strings) {
                try {
                    URL url = new URL(imagePath);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode==200){
                        InputStream inputStream = httpURLConnection.getInputStream();
                        //类型转换
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
                if (bitmap!=null){
                    imageView.setImageBitmap(bitmap);
                }
            }
        }.execute(imagePath);
    }
    /**
     * 判断
     */
    public boolean pd(){
        ConnectivityManager systemService = (ConnectivityManager) App.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        if (activeNetworkInfo!=null){
            boolean available = activeNetworkInfo.isAvailable();
            return available;
        }
        return false;
    }
    public interface CallBack{
        void onCg(String json);
        void onSb(String msg);
    }
}
