package org.polushin.snet.api;

import org.polushin.snet.api.actions.ChatAction;
import org.polushin.snet.api.actions.CommandAction;

import java.util.Objects;

public abstract class EventTracker implements ChatLocker {

    protected final SnetState snetState;

    public EventTracker(SnetState snetState) {
        Objects.requireNonNull(snetState, "State cannot be null!");
        this.snetState = snetState;
    }

    @Override
    public void onCommand(CommandAction command) {

    }

    @Override
    public void onAction(ChatAction action) {

    }

    @Override
    public void onMessage(Message message) {

    }

    /**
     * Called when system is stopped.
     */
    protected abstract void onDisable();
}
