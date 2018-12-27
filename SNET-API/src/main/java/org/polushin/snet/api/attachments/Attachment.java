package org.polushin.snet.api.attachments;

import org.polushin.snet.api.Message;

public interface Attachment {

    /**
     * @return Message that containing this attachment.
     */
    Message getMessage();

}
