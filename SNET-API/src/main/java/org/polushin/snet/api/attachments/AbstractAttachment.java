package org.polushin.snet.api.attachments;

import com.sun.istack.internal.NotNull;
import org.polushin.snet.api.Message;

import java.util.Objects;

public abstract class AbstractAttachment implements Attachment {

    protected final Message message;

    /**
     * @param message Message that containing this attachment.
     */
    protected AbstractAttachment(@NotNull Message message) {
        Objects.requireNonNull(message, "Message cannot be null!");

        this.message = message;
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
