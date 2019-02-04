package com.wyverx.recyclers.domain;

import com.wyverx.recyclers.domain.threading.Executor;
import com.wyverx.recyclers.domain.threading.MainThread;

public abstract class AbstractInteractor implements Interactor {

    protected Executor mThreadExecutor;
    protected MainThread mMainThread;
    protected volatile boolean mIsCanceled;
    protected volatile boolean mIsRunning;


    public AbstractInteractor(Executor threadExecutor, MainThread mainThread) {
        mThreadExecutor = threadExecutor;
        mMainThread = mainThread;
    }


    public abstract void run();


    public void onFinished() {
        mIsRunning = false;
        mIsCanceled = false;
    }


    public void execute() {
        this.mIsRunning = true;
        mThreadExecutor.execute(this);
    }
}
