package org.polushin.snet.api;

import org.polushin.snet.api.attachments.Attachment;

public interface SendMessage extends Message {

    /**
     * Sets the text in the message.
     *
     * @param text New text.
     */
    void setText(String text);

    /**
     * Specifies this message as replay to another message.
     *
     * @param messageId Message ID.
     */
    void setReplayTo(long messageId);

    /**
     * Appends new attachment.
     *
     * @param attachment New attachment.
     *
     * @throws UnsupportedOperationException if this attachment type is not supported by target chat.
     */
    void appendAttachment(Attachment attachment) throws UnsupportedOperationException;

    /**
     * Removes attachment.
     *
     * @param attachment Removing attachment.
     *
     * @return {@code true} if attachment found and removed.
     */
    boolean removeAttachment(Attachment attachment);

    /**
     * Sends current message state to the target chat.
     */
    void send();

}
