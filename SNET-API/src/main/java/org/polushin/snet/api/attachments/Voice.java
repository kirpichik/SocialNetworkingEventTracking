package org.polushin.snet.api.attachments;

import org.polushin.snet.api.Message;

import java.net.URL;

public class Voice extends Audio {

    /**
     * @param message Message that containing this attachment.
     * @param fileId Unique ID of file.
     * @param url URL pointing to this file.
     * @param fileSize Size of this file.
     * @param mimeType MIME-type of this file.
     * @param duration Duration of the audio in seconds.
     */
    public Voice(Message message, String fileId, URL url, long fileSize, String mimeType, long duration) {
        super(message, fileId, url, fileSize, mimeType, duration, null, null);
    }
}
