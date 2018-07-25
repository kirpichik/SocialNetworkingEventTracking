package org.polushin.snet.api;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.polushin.snet.api.attachments.Attachment;

import java.util.Collections;
import java.util.List;

public interface Message {

    /**
     * @return Unique message ID or {@code -1} if not specified.
     */
    default long getMessageId() {
        return -1;
    }

    /**
     * @return Sender of the message or {@code null} if not specified.
     */
    @Nullable
    default User getFrom() {
        return null;
    }

    /**
     * @return Chat where message is located or {@code null} if not specified.
     */
    @Nullable
    default Chat getChat() {
        return null;
    }

    /**
     * @return Date of sending message in UNIX-time or {@code -1} if not specified.
     */
    default long getDate() {
        return -1;
    }

    /**
     * @return The original message for replies or {@code null} if not specified.
     */
    @Nullable
    default Message getReplayTo() {
        return null;
    }

    /**
     * @return Whether this message was edited.
     */
    default boolean isEdited() {
        return false;
    }

    /**
     * @return Date of editing this message in UNIX-time format or {@code -1} if not specified.
     */
    default long getEditDate() {
        return -1;
    }

    /**
     * @return Text or caption of this message or {@code null} if not specified.
     */
    @Nullable
    default String getText() {
        return null;
    }

    /**
     * @return Ordered list of attachments.
     */
    @NotNull
    default List<Attachment> getAttachments() {
        return Collections.emptyList();
    }

    /**
     * Collects attachments by required type.
     *
     * @param type Type of attachments.
     *
     * @return Ordered list of attachments.
     */
    @NotNull
    default List<Attachment> getAttachmentsByType(Class<? extends Attachment> type) {
        return Collections.emptyList();
    }

}
