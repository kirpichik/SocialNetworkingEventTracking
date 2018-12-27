package org.polushin.snet.api.actions;

import com.sun.istack.internal.NotNull;
import org.polushin.snet.api.Chat;
import org.polushin.snet.api.SnetUID;
import org.polushin.snet.api.User;

public class LeftMemberAction extends AbstractChatAction {

    private final User leftMember;

    /**
     * @param kicker Who kicked.
     * @param leftMember Left chat member.
     * @param chat Chat, where was member invited.
     */
    public LeftMemberAction(User kicker, @NotNull User leftMember, @NotNull Chat chat) {
        super(Type.LEFT_MEMBER, SnetUID.UNSPECIFIED, kicker, chat, -1, null);

        this.leftMember = leftMember;
    }

    /**
     * @param leftMember Left chat member.
     * @param chat Chat, where was member invited.
     */
    public LeftMemberAction(@NotNull User leftMember, @NotNull Chat chat) {
        this(null, leftMember, chat);
    }

    /**
     * @return Who left the chat.
     */
    public User getLeftMember() {
        return leftMember;
    }

    /**
     * @return Was the user kicked by another member.
     */
    public boolean isKicked() {
        return getFrom() != null;
    }
}
