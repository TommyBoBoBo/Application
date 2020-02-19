package com.example.mytab;

import android.app.Application;
import android.content.Context;

/**
 * @author: 王重阳
 * @date: 2020/1/8
 */
public class App extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
         context = this;
    }
}
