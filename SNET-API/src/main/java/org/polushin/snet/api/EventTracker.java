package org.polushin.snet.api;

import com.sun.istack.internal.NotNull;
import org.polushin.snet.api.actions.ChatAction;
import org.polushin.snet.api.actions.CommandAction;

import java.util.Objects;

public abstract class EventTracker implements CommandHandler, MessageHandler, ChatActionHandler {

    protected final SnetState snetState;

    private boolean enabled;

    public EventTracker(@NotNull SnetState snetState) {
        Objects.requireNonNull(snetState, "State cannot be null!");
        this.snetState = snetState;
    }

    /**
     * Sets enabled status of this event tracker.
     *
     * @param enabled New enabled status.
     */
    public void setEnabled(boolean enabled) {
        if (enabled == this.enabled)
            return;
        this.enabled = enabled;

        if (enabled)
            onEnable();
        else
            onDisable();
    }

    /**
     * @return Is this event tracker enabled.
     */
    public boolean isEnabled() {
        return enabled;
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

    protected abstract void onEnable();

    protected abstract void onDisable();
}
