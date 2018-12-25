package org.polushin.snet.tg;

import org.polushin.snet.api.SendMessage;
import org.polushin.snet.api.attachments.Attachment;

public class TelegramSendMessage implements SendMessage {

    TelegramSendMessage(TelegramSocialNetwork impl) {

    }

    TelegramSendMessage(TelegramSocialNetwork impl, String text) {

    }

    @Override
    public void setText(String text) {

    }

    @Override
    public void setReplayTo(long messageId) {

    }

    @Override
    public void appendAttachment(Attachment attachment) throws UnsupportedOperationException {

    }

    @Override
    public boolean removeAttachment(Attachment attachment) {
        return false;
    }

    @Override
    public void send() {

    }
}
