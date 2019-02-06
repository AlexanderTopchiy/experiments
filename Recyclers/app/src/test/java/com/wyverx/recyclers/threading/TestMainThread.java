package com.wyverx.recyclers.threading;

import com.wyverx.recyclers.domain.threading.MainThread;

public class TestMainThread implements MainThread {

    @Override
    public void post(Runnable runnable) {
        runnable.run();
    }
}
