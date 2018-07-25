package org.polushin.snet.api.input.attachments;

import com.sun.istack.internal.NotNull;
import org.polushin.snet.api.input.Message;

import java.net.URL;

public class Audio extends AbstractFile {

    private final long duration;
    private final String performer;
    private final String title;

    /**
     * @param message Message that containing this attachment.
     * @param fileId Unique ID of file.
     * @param url URL pointing to this file.
     * @param fileSize Size of this file.
     * @param mimeType MIME-type of this file.
     * @param duration Duration of the audio in seconds.
     * @param performer Performer of the audio.
     * @param title Title of the audio.
     */
    public Audio(@NotNull Message message, String fileId, URL url, long fileSize, String mimeType, long duration,
                 String performer, String title) {
        super(message, fileId, url, fileSize, mimeType);
        this.duration = duration;
        this.performer = performer;
        this.title = title;
    }

    /**
     * @return Duration of the audio in seconds.
     */
    public long getDuration() {
        return duration;
    }

    /**
     * @return Performer of the audio.
     */
    public String getPerformer() {
        return performer;
    }

    /**
     * @return Title of the audio.
     */
    public String getTitle() {
        return title;
    }
}
