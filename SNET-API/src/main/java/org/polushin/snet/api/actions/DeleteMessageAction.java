package org.polushin.snet.api.actions;

import com.sun.istack.internal.NotNull;
import org.polushin.snet.api.Chat;
import org.polushin.snet.api.SnetUID;

public class DeleteMessageAction extends AbstractChatAction {

    private final SnetUID deletedMessageId;

    /**
     * @param deletedMessageId ID of deleted message.
     * @param chat Chat, from where message was deleted.
     */
    public DeleteMessageAction(SnetUID deletedMessageId, @NotNull Chat chat) {
        super(Type.DELETE_MESSAGE, SnetUID.UNSPECIFIED, null, chat, -1, null);

        this.deletedMessageId = deletedMessageId;
    }

    /**
     * @return ID of deleted message.
     */
    public SnetUID getDeletedMessageId() {
        return deletedMessageId;
    }
}
