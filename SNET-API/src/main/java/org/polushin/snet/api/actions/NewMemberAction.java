package org.polushin.snet.api.actions;

import com.sun.istack.internal.NotNull;
import org.polushin.snet.api.Chat;
import org.polushin.snet.api.User;

import java.util.Objects;

public class NewMemberAction extends AbstractChatAction {

    private final User newMember;

    /**
     * @param inviter Who invited.
     * @param newMember New chat member.
     * @param chat Chat, where was member invited.
     */
    public NewMemberAction(User inviter, @NotNull User newMember, @NotNull Chat chat) {
        super(Type.NEW_MEMBER, -1, inviter, chat, -1, null);

        Objects.requireNonNull(newMember, "New member cannot be null!");

        this.newMember = newMember;
    }

    /**
     * @param newMember New chat member.
     * @param chat Chat, where was member invited.
     */
    public NewMemberAction(@NotNull User newMember, @NotNull Chat chat) {
        this(null, newMember, chat);
    }

    /**
     * @return New chat member.
     */
    public User getNewMember() {
        return newMember;
    }

    /**
     * @return Was the user invited by another member.
     */
    public boolean isInvited() {
        return getFrom() != null;
    }
}
