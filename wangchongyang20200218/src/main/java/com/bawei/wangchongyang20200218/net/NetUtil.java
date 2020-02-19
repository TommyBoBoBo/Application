package com.bawei.wangchongyang20200218.net;

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

import com.bawei.wangchongyang20200218.app.App;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author: 王重阳
 * @date: 2020/2/18
 */
public class NetUtil {
    //单例
    private static NetUtil instance;
    private NetUtil(){}
    public static NetUtil getInstance() {
        if (instance==null) {
            instance=new NetUtil();
        }

        return instance;
    }


    //doGet请求方法
    public void doGet(final String path, final CallBack callBack){

        //判断网络
        boolean net = net();
        if (!net) {
            Toast.makeText(App.context, "网络异常", Toast.LENGTH_SHORT).show();
        }

        //切换线程
        new AsyncTask<String, Void, String>() {
            //子线程网络请求数据
            @Override
            protected String doInBackground(String... strings) {

                try {
                    URL url = new URL(path);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    //连接超时时间为5s
                    httpURLConnection.setConnectTimeout(5000);
                    //读取超时时间为5s
                    httpURLConnection.setReadTimeout(5000);
                    //用get方法请求数据
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();
                    //返回响应码
                    int responseCode = httpURLConnection.getResponseCode();
                    //200表示成功
                    if (responseCode==200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        int len = -1;
                        byte[] bytes = new byte[1024];
                        StringBuffer stringBuffer = new StringBuffer();
                        while ((len =inputStream.read(bytes))!=-1){

                            stringBuffer.append(new String(bytes,0,len));

                        }
                        //获取到json
                        String json = stringBuffer.toString();
                        Log.d("xxx", "doInBackground: "+json);
                        //关流
                        inputStream.close();
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
                    callBack.onbai("请求失败");
                }
            }
        }.execute(path);


    }

    //图片doGet请求方法
    public void imagedoGet(final String imagepath, final ImageView imageView){

        //判断网络
        boolean net = net();
        if (!net) {
            Toast.makeText(App.context, "网络异常", Toast.LENGTH_SHORT).show();
        }

        //切换线程
        new AsyncTask<String, Void, Bitmap>() {
            //子线程网络请求数据
            @Override
            protected Bitmap doInBackground(String... strings) {

                try {
                    URL url = new URL(imagepath);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    //连接超时时间为5s
                    httpURLConnection.setConnectTimeout(5000);
                    //读取超时时间为5s
                    httpURLConnection.setReadTimeout(5000);
                    //用get方法请求数据
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();
                    //返回响应码
                    int responseCode = httpURLConnection.getResponseCode();
                    //200表示成功
                    if (responseCode==200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                        //关流
                        inputStream.close();
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





    //判断网络工具类
    protected boolean net(){
        ConnectivityManager systemService = (ConnectivityManager) App.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        if (activeNetworkInfo!=null) {
            boolean available = activeNetworkInfo.isAvailable();
            return available;
        }
        return false;
    }
    //创建接口
    public interface CallBack{
        void  oncheng(String json);
        void  onbai(String msg);
    }

}
