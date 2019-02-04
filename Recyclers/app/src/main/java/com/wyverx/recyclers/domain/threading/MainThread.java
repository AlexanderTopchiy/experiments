package com.wyverx.recyclers.domain.threading;

public interface MainThread {

    void post(final Runnable runnable);
}
