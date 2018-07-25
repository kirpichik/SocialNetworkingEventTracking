package org.polushin.snet.api.input;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.polushin.snet.api.input.attachments.*;

import java.util.Collection;
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
     * @return All attachments, the type of which is specific to the social network.
     */
    @NotNull
    default Collection<Attachment> getUnknownAttachments() {
        return Collections.emptyList();
    }

    /**
     * @return Forwarded messages attached to this message.
     */
    @NotNull
    default Collection<ForwardedMessage> getForwardedMessages() {
        return Collections.emptyList();
    }

    /**
     * @return Audio-files attached to this message.
     */
    @NotNull
    default Collection<Audio> getAudios() {
        return Collections.emptyList();
    }

    /**
     * @return Documents attached to this message.
     */
    @NotNull
    default Collection<File> getFiles() {
        return Collections.emptyList();
    }

    /**
     * @return Images attached to this message.
     */
    @NotNull
    default Collection<Photo> getPhotos() {
        return Collections.emptyList();
    }

    /**
     * @return Videos attached to this message.
     */
    @NotNull
    default Collection<Video> getVideos() {
        return Collections.emptyList();
    }

    /**
     * @return Voice messages attached to this message.
     */
    @NotNull
    default Collection<Voice> getVoices() {
        return Collections.emptyList();
    }

    /**
     * @return Stickers attached to this message.
     */
    @NotNull
    default Collection<Sticker> getStickers() {
        return Collections.emptyList();
    }

}
