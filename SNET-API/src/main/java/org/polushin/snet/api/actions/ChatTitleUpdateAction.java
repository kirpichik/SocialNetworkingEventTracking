package org.polushin.snet.api.actions;

import com.sun.istack.internal.NotNull;
import org.polushin.snet.api.Chat;
import org.polushin.snet.api.SnetUID;
import org.polushin.snet.api.User;

import java.util.Objects;

public class ChatTitleUpdateAction extends AbstractChatAction {

    private final String newTitle;

    /**
     * @param messageId Action message ID.
     * @param from Who updated title.
     * @param chat Chat, where title was updated.
     * @param date Time of update.
     * @param newTitle New chat title.
     */
    public ChatTitleUpdateAction(SnetUID messageId, @NotNull User from, @NotNull Chat chat, long date, @NotNull String
            newTitle) {
        super(Type.CHAT_TITLE_UPDATE, messageId, from, chat, date, null);

        Objects.requireNonNull(from, "User cannot be null!");
        Objects.requireNonNull(newTitle, "Title cannot be null!");

        this.newTitle = newTitle;
    }

    /**
     * @return New title.
     */
    @NotNull
    public String getNewTitle() {
        return newTitle;
    }
}
