package org.polushin.snet.api;

import com.sun.istack.internal.NotNull;

import java.util.Objects;

public abstract class SocialNetwork {

    protected SnetState snetState;

    public SocialNetwork(@NotNull SnetState state) {
        Objects.requireNonNull(state, "State cannot be null!");

        this.snetState = state;
    }

    public abstract void destroy();

}
