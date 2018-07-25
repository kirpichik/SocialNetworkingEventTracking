package org.polushin.snet.api.input.attachments;

import com.sun.istack.internal.NotNull;
import org.polushin.snet.api.input.Message;

public interface Attachment {

    /**
     * @return Message that containing this attachment.
     */
    @NotNull
    Message getMessage();

}
