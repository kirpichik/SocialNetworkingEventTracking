package org.polushin.snet.api.attachments;

import com.sun.istack.internal.NotNull;
import org.polushin.snet.api.Message;

public interface Attachment {

    /**
     * @return Message that containing this attachment.
     */
    @NotNull
    Message getMessage();

}
