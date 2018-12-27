package org.polushin.snet.api;

import org.polushin.snet.api.attachments.Photo;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Future;

public interface Chat {

    /**
     * @return Current chat pinned message or {@code null} if not specified.
     */
    Future<Message> getPinnedMessage();

    /**
     * @return Chat photo or {@code null} if not specified.
     */
    Future<Photo> getPhoto();

    /**
     * @return Chat title or {@code null} if not specified.
     */
    Future<String> getTitle();

    /**
     * @return Collection of chat members.
     */
    Future<Collection<User>> getUsers();

    /**
     * @return Unique ID of this chat.
     */
    SnetUID getChatId();

    /**
     * Requests message from this chat by ID.
     *
     * @param messageId Message ID.
     *
     * @throws IllegalArgumentException if message id from another implementation.
     *
     * @return Message object or {@code null} if not found.
     */
    Future<Message> getMessage(SnetUID messageId) throws IllegalArgumentException;

    /**
     * Forward messages by id from this chat with specified message.
     *
     * @param message Message that will contain forwarded messages.
     * @param messageIds Messages IDs.
     *
     * @throws IllegalArgumentException if message ids or send message from another implementation.
     */
    default void forwardMessages(SendMessage message, SnetUID... messageIds) throws IllegalArgumentException {
        forwardMessages(message, Arrays.asList(messageIds));
    }

    /**
     * Forward messages by id from this chat with specified message.
     *
     * @param message Message that will contain forwarded messages.
     * @param messageIds Messages IDs.
     *
     * @throws IllegalArgumentException if message ids or send message from another implementation.
     */
    void forwardMessages(SendMessage message, Collection<SnetUID> messageIds) throws IllegalArgumentException;

    /**
     * Builds message to this chat.
     *
     * @return Building message.
     */
    SendMessage sendMessage();

    /**
     * Builds message with text to this chat.
     *
     * @param text Text in message.
     *
     * @return Building message.
     */
    SendMessage sendMessage(String text);

    /**
     * @return {@code true} if this chat supports messages editing.
     */
    default boolean isEditingSupports() {
        return false;
    }

    /**
     * @return {@code true} if this chat supports messages deleting.
     */
    default boolean isDeletingSupports() {
        return false;
    }

    /**
     * Edit required message in this chat.
     *
     * @param messageId Message ID.
     *
     * @return Edit message object.
     *
     * @throws UnsupportedOperationException if chat is not supported messages edit.
     * @throws IllegalArgumentException if message id from another implementation.
     */
    default SendMessage editMessage(SnetUID messageId) throws UnsupportedOperationException, IllegalArgumentException {
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
     * @throws IllegalArgumentException if message from another implementation.
     */
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
     * @throws IllegalArgumentException if message id from another implementation.
     */
    default boolean deleteMessage(SnetUID messageId) throws UnsupportedOperationException, IllegalArgumentException {
        throw new UnsupportedOperationException("This chat implementation does not support deleting messages!");
    }

    /**
     * Request chat lock.
     *
     * @param locker New locker.
     *
     * @return {@code true} if locked successfully.
     */
    boolean tryLock(ChatLocker locker);

    /**
     * Waits to be able to lock this chat.
     *
     * @param locker New locker.
     *
     * @throws InterruptedException If wait was interrupted.
     */
    void lock(ChatLocker locker) throws InterruptedException;

    /**
     * @return Is this chat already locked.
     */
    boolean isLocked();

    /**
     * Unlocks this chat.
     *
     * Please do not unlock chat if you are not sure that you locked it.
     */
    void unlock();

    /**
     * @return Current locker of this chat.
     */
    ChatLocker getLocker();

    /**
     * Checks two chat rooms for equivalence.
     * Required for storing chats in standard Java containers.
     *
     * @param o Object to compare.
     *
     * @return {@code true} if this object is the same as provided.
     */
    boolean equals(Object o);

    /**
     * Returns a hash code value for the object.
     * Required for storing chats in standard Java containers.
     *
     * Hash code must include Social Network implementation identifier
     * and chat ID number.
     *
     * @return hash code for this chat object.
     */
    int hashCode();

}
