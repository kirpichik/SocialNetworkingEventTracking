package org.polushin.snet.api.input.attachments;

import com.sun.istack.internal.NotNull;
import org.polushin.snet.api.input.Message;

import java.net.URL;

public class Sticker extends Photo {

    /**
     * @param message Message that containing this attachment.
     * @param fileId Unique ID of this file.
     * @param url URL pointing to this file.
     * @param fileSize Size of this file.
     * @param mimeType MIME-type of this file.
     * @param width Width of photo.
     * @param height Height of photo.
     */
    public Sticker(@NotNull Message message, String fileId, URL url, long fileSize, String mimeType, int width, int
            height) {
        super(message, fileId, url, fileSize, mimeType, width, height);
    }
}
