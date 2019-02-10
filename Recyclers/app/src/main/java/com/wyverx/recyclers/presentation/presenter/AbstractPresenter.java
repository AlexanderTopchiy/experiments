package com.wyverx.recyclers.presentation.presenter;

import com.wyverx.recyclers.domain.threading.Executor;
import com.wyverx.recyclers.domain.threading.MainThread;

public abstract class AbstractPresenter {

    protected Executor mExecutor;
    protected MainThread mMainThread;


    public AbstractPresenter(Executor executor, MainThread mainThread) {
        mExecutor = executor;
        mMainThread = mainThread;
    }
}
