package org.polushin.snet.api.actions;

import com.sun.istack.internal.NotNull;
import org.polushin.snet.api.Chat;

public class DeleteMessageAction extends AbstractChatAction {

    private final long deletedMessageId;

    /**
     * @param deletedMessageId ID of deleted message.
     * @param chat Chat, from where message was deleted.
     */
    public DeleteMessageAction(long deletedMessageId, @NotNull Chat chat) {
        super(Type.DELETE_MESSAGE, -1, null, chat, -1, null);

        this.deletedMessageId = deletedMessageId;
    }

    /**
     * @return ID of deleted message.
     */
    public long getDeletedMessageId() {
        return deletedMessageId;
    }
}
