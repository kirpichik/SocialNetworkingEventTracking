package org.polushin.snet.api.attachments;

import com.sun.istack.internal.NotNull;
import org.polushin.snet.api.Chat;
import org.polushin.snet.api.Message;

import java.util.Objects;

public class AbstractForwardedMessage extends AbstractAttachment implements ForwardedMessage {

    private final Chat forwardedFrom;

    /**
     * @param message Message that containing this attachment.
     * @param forwardedFrom Chat from which the message was forwarded.
     */
    protected AbstractForwardedMessage(Message message, @NotNull Chat forwardedFrom) {
        super(message);

        Objects.requireNonNull(forwardedFrom, "Chat cannot be null!");

        this.forwardedFrom = forwardedFrom;
    }

    @Override
    public Chat getForwardedFrom() {
        return forwardedFrom;
    }
}
