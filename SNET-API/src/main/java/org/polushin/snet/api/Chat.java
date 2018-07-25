package org.polushin.snet.api;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.polushin.snet.api.attachments.Photo;

import java.util.Collection;

public interface Chat {

    /**
     * @return Current chat pinned message or {@code null} if not specified.
     */
    @Nullable
    Message getPinnedMessage();

    /**
     * @return Chat photo or {@code null} if not specified.
     */
    @Nullable
    Photo getPhoto();

    /**
     * @return Chat title or {@code null} if not specified.
     */
    @Nullable
    String getTitle();

    /**
     * @return Collection of chat members.
     */
    @NotNull
    Collection<User> getUsers();

    /**
     * @return Unique ID of this chat.
     */
    long getChatId();

    /**
     * Requests message from this chat by ID.
     *
     * @param messageId Message ID.
     *
     * @return Message object or {@code null} if not found.
     */
    @Nullable
    Message getMessage(long messageId);

    /**
     * Forward messages by id from this chat with specified message.
     *
     * @param message Message that will contain forwarded messages.
     * @param messageIds Messages IDs.
     */
    void forwardMessages(SendMessage message, long... messageIds);

    /**
     * Builds message to this chat.
     *
     * @return Building message.
     */
    @NotNull
    SendMessage sendMessage();

    /**
     * Builds message with text to this chat.
     *
     * @param text Text in message.
     *
     * @return Building message.
     */
    @NotNull
    SendMessage sendMessage(String text);

    /**
     * @return {@code true} if this chat supports messages editing.
     */
    boolean isEditingSupports();

    /**
     * @return {@code true} if this chat supports messages deleting.
     */
    boolean isDeletingSupports();

    /**
     * Edit required message in this chat.
     *
     * @param messageId Message ID.
     *
     * @return Edit message object.
     *
     * @throws UnsupportedOperationException if chat is not supported messages edit.
     */
    @NotNull
    default SendMessage editMessage(long messageId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This chat implementation does not support editing messages!");
    }

    /**
     * Edit required message in this chat.
     *
     * Copies message data from specified message.
     *
     * @param message Message to edit.
     *
     * @return Edit message object.
     *
     * @throws UnsupportedOperationException if chat is not supported messages edit.
     */
    @NotNull
    default SendMessage editMessage(Message message) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This chat implementation does not support editing messages!");
    }

    /**
     * Delete required message in this chat.
     *
     * @param messageId Message ID.
     *
     * @return {@code true} if message was deleted.
     *
     * @throws UnsupportedOperationException if chat is not supported messages edit.
     */
    @NotNull
    default boolean deleteMessage(long messageId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This chat implementation does not support deleting messages!");
    }

}
