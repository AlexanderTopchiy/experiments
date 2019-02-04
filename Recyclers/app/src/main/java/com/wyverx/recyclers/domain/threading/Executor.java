package com.wyverx.recyclers.domain.threading;

import com.wyverx.recyclers.domain.AbstractInteractor;

public interface Executor {

    void execute(final AbstractInteractor interactor);
}
