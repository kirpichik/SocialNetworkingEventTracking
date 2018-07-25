package org.polushin.snet.api.input.attachments;

import com.sun.istack.internal.NotNull;
import org.polushin.snet.api.input.Message;

import java.net.URL;

public abstract class AbstractFile extends AbstractAttachment implements File {

    protected final String fileId;
    protected final URL url;
    protected final long fileSize;
    protected final String mimeType;

    /**
     * @param message Message that containing this attachment.
     * @param fileId Unique ID of this file.
     * @param url URL pointing to this file.
     * @param fileSize Size of this file.
     * @param mimeType MIME-type of this file.
     */
    protected AbstractFile(@NotNull Message message, String fileId, URL url, long fileSize, String mimeType) {
        super(message);

        this.fileId = fileId;
        this.url = url;
        this.fileSize = fileSize;
        this.mimeType = mimeType;
    }

    @Override
    public String getFileId() {
        return fileId;
    }

    @Override
    public URL getURL() {
        return url;
    }

    @Override
    public long getFileSize() {
        return fileSize;
    }

    @Override
    public String getMimeType() {
        return mimeType;
    }
}
