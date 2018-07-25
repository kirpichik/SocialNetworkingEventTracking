package org.polushin.snet.api.attachments;

import java.net.URL;

public interface File extends Attachment {

    /**
     * @return Unique ID of this file or {@code null} if not specified.
     */
    String getFileId();

    /**
     * @return URL, from where the file can be downloaded or {@code null} if not specified.
     */
    URL getURL();

    /**
     * @return File size or {@code -1} if not specified.
     */
    long getFileSize();

    /**
     * @return MIME-type of this file.
     */
    String getMimeType();

}
