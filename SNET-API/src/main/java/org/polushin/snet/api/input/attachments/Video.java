package org.polushin.snet.api.input.attachments;

import org.polushin.snet.api.input.Message;

import java.net.URL;

public class Video extends AbstractFile {

    private final int width, height;
    private final Photo thumb;

    /**
     * @param message Message that containing this attachment.
     * @param fileId Unique ID of this file.
     * @param url URL pointing to this file.
     * @param fileSize Size of this file.
     * @param mimeType MIME-type of this file.
     */
    protected Video(Message message, String fileId, URL url, long fileSize, String mimeType, int width, int height,
                    Photo thumb) {
        super(message, fileId, url, fileSize, mimeType);

        this.width = width;
        this.height = height;
        this.thumb = thumb;
    }

    /**
     * @return Width of this video.
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return Height of this video.
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return Thumb for this video.
     */
    public Photo getThumb() {
        return thumb;
    }
}
