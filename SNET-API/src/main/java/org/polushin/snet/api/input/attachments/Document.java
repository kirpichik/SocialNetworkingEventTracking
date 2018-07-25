package org.polushin.snet.api.input.attachments;

import com.sun.istack.internal.NotNull;
import org.polushin.snet.api.input.Message;

import java.net.URL;

public class Document extends AbstractFile {

    private final String filename;

    /**
     * @param message Message that containing this attachment.
     * @param fileId Unique ID of this file.
     * @param url URL pointing to this file.
     * @param fileSize Size of this file.
     * @param mimeType MIME-type of this file.
     * @param filename Name of this file.
     */
    public Document(@NotNull Message message, String fileId, URL url, long fileSize, String mimeType, String filename) {
        super(message, fileId, url, fileSize, mimeType);

        this.filename = filename;
    }

    /**
     * @return Name of this file.
     */
    public String getFilename() {
        return filename;
    }
}
