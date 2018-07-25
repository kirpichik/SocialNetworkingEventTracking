package org.polushin.snet.api.actions;

import com.sun.istack.internal.NotNull;
import org.polushin.snet.api.Chat;
import org.polushin.snet.api.Message;

public abstract class EditMessageAction extends AbstractChatAction {

    private final long editedMessageId;

    /**
     * @param editedMessageId ID of edited message.
     * @param chat Chat, from where message was edited.
     */
    public EditMessageAction(long editedMessageId, @NotNull Chat chat) {
        super(Type.EDIT_MESSAGE, -1, null, chat, -1, null);

        this.editedMessageId = editedMessageId;
    }

    /**
     * @return ID of edited message.
     */
    public long getEditedMessageId() {
        return editedMessageId;
    }

    /**
     * @return Full edited message object.
     */
    public abstract Message getEditedMessage();
}
