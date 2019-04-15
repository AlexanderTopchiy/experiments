package com.wyverx.recyclers;

import android.app.Application;
import android.content.Context;

import java.lang.ref.SoftReference;

public class RecyclersApplication extends Application {

    public static SoftReference<Context> contextReference;

    @Override
    public void onCreate() {
        super.onCreate();
        contextReference = new SoftReference<>(getApplicationContext());
    }
}
