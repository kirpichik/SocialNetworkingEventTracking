package org.polushin.snet.api.actions;

import org.polushin.snet.api.Message;

public interface ChatAction extends Message {

    /**
     * @return Action type.
     */
    Type getType();

    enum Type {
        UNKNOWN,
        COMMAND,
        DELETE_MESSAGE,
        EDIT_MESSAGE,
        CHAT_TITLE_UPDATE,
        CHAT_PHOTO_UPDATE,
        MESSAGE_ATTACHED,
        NEW_MEMBER,
        LEFT_MEMBER
    }

}
