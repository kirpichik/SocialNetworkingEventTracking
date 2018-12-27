package org.polushin.snet.api;

import org.polushin.snet.api.attachments.Attachment;

import java.util.Collection;
import java.util.List;

public interface SendMessage {

    /**
     * @return Chat to which the message should be sent.
     */
    Chat getChat();

    /**
     * Sets the text in the message.
     *
     * @param text New text.
     *
     * @return Current send message object.
     */
    SendMessage setText(String text);

    /**
     * @return Text or caption of this message or {@code null} if not specified.
     */
    String getText();

    /**
     * Specifies this message as replay to another message.
     *
     * @param messageId Message ID.
     *
     * @throws UnsupportedOperationException if message id from another implementation.
     *
     * @return Current send message object.
     */
    SendMessage setReplayTo(SnetUID messageId) throws UnsupportedOperationException;

    /**
     * @return ID of replaying message.
     */
    SnetUID getReplayTo();

    /**
     * @return {@code true} if this object represents editing message.
     */
    boolean isMessageEditing();

    /**
     * @return Editing message id or {@code null}.
     */
    SnetUID getEditingMessageId();

    /**
     * @return {@code true} if attachments supported by this implementation.
     */
    boolean isAttachmentsSupported();

    /**
     * Appends new attachment. If implementation does not support
     * attachments, ignore it.
     *
     * @param attachments New attachments.
     *
     * @return Current send message object.
     */
    SendMessage appendAttachments(Attachment... attachments);

    /**
     * Appends new attachment. If implementation does not support
     * attachments, ignore it.
     *
     * @param attachments New attachments.
     *
     * @return Current send message object.
     */
    SendMessage appendAttachments(Collection<Attachment> attachments);

    /**
     * @return Ordered list of attachments.
     */
    List<Attachment> getAttachments();

    /**
     * Collects attachments by required type.
     *
     * @param type Type of attachments.
     *
     * @return Ordered list of attachments.
     */
    Collection<Attachment> getAttachmentsByType(Class<? extends Attachment> type);

    /**
     * Removes attachment.
     *
     * @param attachment Removing attachment.
     */
    void removeAttachment(Attachment attachment);

    /**
     * Sends current message state to the target chat.
     */
    void send();

}
