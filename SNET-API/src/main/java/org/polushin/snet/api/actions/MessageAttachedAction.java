package org.polushin.snet.api.actions;

import com.sun.istack.internal.NotNull;
import org.polushin.snet.api.Chat;
import org.polushin.snet.api.Message;
import org.polushin.snet.api.SnetUID;
import org.polushin.snet.api.User;

import java.util.Objects;
import java.util.concurrent.Future;

public abstract class MessageAttachedAction extends AbstractChatAction {

    private final long attachedMessageId;

    /**
     * @param attachedMessageId ID of attached message.
     * @param from Who attached message.
     * @param chat Chat, where message was attached.
     */
    public MessageAttachedAction(long attachedMessageId, @NotNull User from, @NotNull Chat chat) {
        super(Type.MESSAGE_ATTACHED, SnetUID.UNSPECIFIED, from, chat, -1, null);

        Objects.requireNonNull(from, "User cannot be null!");

        this.attachedMessageId = attachedMessageId;
    }

    /**
     * @return ID of attached message.
     */
    public long getAttachedMessageId() {
        return attachedMessageId;
    }

    /**
     * @return Full attached message object.
     */
    public abstract Future<Message> getAttachedMessage();
}
