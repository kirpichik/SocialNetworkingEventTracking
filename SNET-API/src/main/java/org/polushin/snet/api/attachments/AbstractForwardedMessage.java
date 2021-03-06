package org.polushin.snet.api.attachments;

import org.polushin.snet.api.Chat;
import org.polushin.snet.api.Message;

import java.util.Objects;

public abstract class AbstractForwardedMessage extends AbstractAttachment implements ForwardedMessage {

    private final Chat forwardedFrom;

    /**
     * @param message Message that containing this attachment.
     * @param forwardedFrom Chat from which the message was forwarded.
     */
    protected AbstractForwardedMessage(Message message, Chat forwardedFrom) {
        super(message);

        Objects.requireNonNull(forwardedFrom, "Chat cannot be null!");

        this.forwardedFrom = forwardedFrom;
    }

    @Override
    public Chat getForwardedFrom() {
        return forwardedFrom;
    }
}
