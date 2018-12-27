package org.polushin.snet.api.actions;

import org.polushin.snet.api.Chat;
import org.polushin.snet.api.SnetUID;
import org.polushin.snet.api.User;

import java.util.Objects;

public class NewMemberAction extends AbstractChatAction {

    private final User newMember;

    /**
     * @param inviter Who invited.
     * @param newMember New chat member.
     * @param chat Chat, where was member invited.
     */
    public NewMemberAction(User inviter, User newMember, Chat chat) {
        super(Type.NEW_MEMBER, SnetUID.UNSPECIFIED, inviter, chat, -1, null);

        Objects.requireNonNull(newMember, "New member cannot be null!");

        this.newMember = newMember;
    }

    /**
     * @param newMember New chat member.
     * @param chat Chat, where was member invited.
     */
    public NewMemberAction(User newMember, Chat chat) {
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
