package org.polushin.snet.api.actions;

import org.polushin.snet.api.Chat;
import org.polushin.snet.api.SnetUID;
import org.polushin.snet.api.User;
import org.polushin.snet.api.attachments.Photo;

import java.util.Objects;

public class ChatPhotoUpdateAction extends AbstractChatAction {

    private final Photo newPhoto;

    /**
     * @param messageId Action message ID.
     * @param from Who updated photo.
     * @param chat Chat, where photo was updated.
     * @param date Time of update.
     * @param newPhoto New chat photo.
     */
    public ChatPhotoUpdateAction(SnetUID messageId, User from, Chat chat, long date, Photo
            newPhoto) {
        super(Type.CHAT_PHOTO_UPDATE, messageId, from, chat, date, null);

        Objects.requireNonNull(from, "User cannot be null!");
        Objects.requireNonNull(newPhoto, "Photo cannot be null!");

        this.newPhoto = newPhoto;
    }

    /**
     * @return New chat photo.
     */
    public Photo getNewPhoto() {
        return newPhoto;
    }
}
