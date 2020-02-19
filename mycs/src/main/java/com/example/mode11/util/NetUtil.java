package com.example.mode11.util;

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

import com.example.mode11.app.App;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ProjectName: My Application
 * @Package: com.example.mode11.util
 * @ClassName: NetUtil
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/1/3 14:04
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/3 14:04
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NetUtil {
    private static final String TAG = "NetUtil";
    //单例模式
    public NetUtil(){}
    public static NetUtil instance;

    public static NetUtil getInstance() {
        instance = new NetUtil();
        return instance;
    }

    /**
     *
     * @param path
     * @param callBack
     */
    @SuppressLint("StaticFieldLeak")
    public void doGet(final String path, final CallBack callBack){
        boolean pd = Pd();
        if (!pd){
            Toast.makeText(App.context, "网络异常", Toast.LENGTH_SHORT).show();
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
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode==200){
                        InputStream inputStream = httpURLConnection.getInputStream();
                        int len = -1;
                        byte[] bytes = new byte[1024];
                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        while ((len = inputStream.read(bytes))!=-1){
                            outputStream.write(bytes,0,len);
                        }
                        String json = outputStream.toString();
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
    //
    @SuppressLint("StaticFieldLeak")
    public void TuPian(final String imagePath, final ImageView imageView){
        boolean pd = Pd();
        if (!pd){
            Toast.makeText(App.context, "网络异常", Toast.LENGTH_SHORT).show();
        }
        new AsyncTask<String, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... strings) {
                try {
                    URL url = new URL(imagePath);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
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
     * 判断网络状态
     * @return
     */
    public boolean Pd(){
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
