package com.wyverx.recyclers.domain.threading;

import android.os.Handler;
import android.os.Looper;

public class MainThread {

    private static volatile MainThread sMainThread;
    private Handler mHandler;


    private MainThread() {
        mHandler = new Handler(Looper.getMainLooper());
    }


    public void post(Runnable runnable) {
        mHandler.post(runnable);
    }


    public static MainThread getInstance() {
        if (sMainThread == null) {
            synchronized (MainThread.class) {
                if (sMainThread == null) {
                    sMainThread = new MainThread();
                }
            }
        }
        return sMainThread;
    }
}
