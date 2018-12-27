package org.polushin.snet.api.actions;

import org.polushin.snet.api.Chat;
import org.polushin.snet.api.Message;
import org.polushin.snet.api.SnetUID;

import java.util.concurrent.Future;

public abstract class EditMessageAction extends AbstractChatAction {

    private final SnetUID editedMessageId;

    /**
     * @param editedMessageId ID of edited message.
     * @param chat Chat, from where message was edited.
     */
    public EditMessageAction(SnetUID editedMessageId, Chat chat) {
        super(Type.EDIT_MESSAGE, SnetUID.UNSPECIFIED, null, chat, -1, null);

        this.editedMessageId = editedMessageId;
    }

    /**
     * @return ID of edited message.
     */
    public SnetUID getEditedMessageId() {
        return editedMessageId;
    }

    /**
     * @return Full edited message object.
     */
    public abstract Future<Message> getEditedMessage();
}
