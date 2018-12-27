package org.polushin.snet.tg;

import org.polushin.snet.api.Message;
import org.polushin.snet.api.SnetUID;
import org.polushin.snet.api.attachments.Attachment;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class TelegramMessage implements Message {

    private final TelegramBotImpl impl;
    private final org.telegram.telegrambots.meta.api.objects.Message source;
    private final Map<Class<? extends Attachment>, Collection<Attachment>> attachments = new HashMap<>();
    private final List<Attachment> sortedAttachments = new ArrayList<>();
    private final SnetUID id;

    private TelegramMessage replayToMessage;
    private TelegramUser from;
    private TelegramChat chat;

    TelegramMessage(TelegramBotImpl impl, org.telegram.telegrambots.meta.api.objects.Message source) {
        this.impl = impl;
        this.source = source;
        Integer id = source.getMessageId();
        if (id == null)
            this.id = SnetUID.UNSPECIFIED;
        else
            this.id = SnetUID.getId(id, TelegramSocialNetwork.class);
        buildAttachments();
    }

    private void buildAttachments() {
        // TODO - collect all attachments
    }

    @Override
    public SnetUID getMessageId() {
        return id;
    }

    @Override
    public TelegramUser getFrom() {
        if (source.getFrom() == null)
            return null;
        if (from == null)
            from = new TelegramUser(impl, source.getFrom());
        return from;
    }

    @Override
    public TelegramChat getChat() {
        if (source.getChat() == null)
            return null;
        if (chat == null)
            chat = new TelegramChat(impl, source.getChat());
        return chat;
    }

    @Override
    public long getDate() {
        Integer date = source.getDate();
        return date == null ? 0 : date;
    }

    @Override
    public Future<Message> getReplayTo() {
        if (!source.isReply())
            return CompletableFuture.completedFuture(null);
        if (replayToMessage == null)
            replayToMessage = new TelegramMessage(impl, source.getReplyToMessage());
        return CompletableFuture.completedFuture(replayToMessage);
    }

    @Override
    public SnetUID getReplayToId() {
        if (!source.isReply())
            return SnetUID.UNSPECIFIED;
        if (replayToMessage == null)
            replayToMessage = new TelegramMessage(impl, source.getReplyToMessage());
        return replayToMessage.getReplayToId();
    }

    @Override
    public boolean isEdited() {
        return source.getEditDate() != null;
    }

    @Override
    public long getEditDate() {
        Integer date = source.getEditDate();
        return date == null ? 0 : date;
    }

    @Override
    public String getText() {
        return source.hasText() ? source.getText() : null;
    }

    @Override
    public List<Attachment> getAttachments() {
        return sortedAttachments;
    }

    @Override
    public Collection<Attachment> getAttachmentsByType(Class<? extends Attachment> type) {
        return attachments.get(type);
    }
}
