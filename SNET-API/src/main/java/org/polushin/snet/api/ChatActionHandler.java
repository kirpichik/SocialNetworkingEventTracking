package org.polushin.snet.api;

import org.polushin.snet.api.actions.ChatAction;

@FunctionalInterface
public interface ChatActionHandler {

    void onAction(ChatAction action);

}
