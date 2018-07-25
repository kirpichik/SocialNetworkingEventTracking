package org.polushin.snet.api.input.attachments;

import com.sun.istack.internal.Nullable;
import org.polushin.snet.api.input.Chat;
import org.polushin.snet.api.input.Message;

public interface ForwardedMessage extends Message, Attachment {

    /**
     * @return Chat from which the message was forwarded or {@code null} if not specified.
     */
    @Nullable
    Chat getForwardedFrom();

}
