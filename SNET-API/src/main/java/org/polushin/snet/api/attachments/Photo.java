package org.polushin.snet.api.attachments;

import org.polushin.snet.api.Message;

import java.net.URL;

public class Photo extends AbstractFile {

    private final int width, height;

    /**
     * @param message Message that containing this attachment.
     * @param fileId Unique ID of this file.
     * @param url URL pointing to this file.
     * @param fileSize Size of this file.
     * @param mimeType MIME-type of this file.
     * @param width Width of photo.
     * @param height Height of photo.
     */
    public Photo(Message message, String fileId, URL url, long fileSize, String mimeType, int width, int
            height) {
        super(message, fileId, url, fileSize, mimeType);

        this.width = width;
        this.height = height;
    }

    /**
     * @return Width of photo.
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return Height of photo.
     */
    public int getHeight() {
        return height;
    }
}
