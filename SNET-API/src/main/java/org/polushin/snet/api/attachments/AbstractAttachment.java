package org.polushin.snet.api.attachments;

import org.polushin.snet.api.Message;

import java.util.Objects;

public abstract class AbstractAttachment implements Attachment {

    protected final Message message;

    /**
     * @param message Message that containing this attachment.
     */
    protected AbstractAttachment(Message message) {
        Objects.requireNonNull(message, "Message cannot be null!");

        this.message = message;
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
