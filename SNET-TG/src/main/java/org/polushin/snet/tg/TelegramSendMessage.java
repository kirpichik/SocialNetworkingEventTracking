package org.polushin.snet.tg;

import org.polushin.snet.api.Chat;
import org.polushin.snet.api.SendMessage;
import org.polushin.snet.api.SnetUID;
import org.polushin.snet.api.attachments.Attachment;

import java.util.Collection;
import java.util.List;

public class TelegramSendMessage implements SendMessage {

    private final TelegramBotImpl impl;
    private final Chat chat;
    private final SnetUID editingMessageId;

    private String text;
    private SnetUID replayTo;

    TelegramSendMessage(TelegramBotImpl impl, Chat chat, SnetUID editingMessageId) {
        this.impl = impl;
        this.chat = chat;
        this.editingMessageId = editingMessageId;
    }

    TelegramSendMessage(TelegramBotImpl impl, Chat chat) {
        this(impl, chat, (SnetUID) null);
    }

    TelegramSendMessage(TelegramBotImpl impl, Chat chat, String text) {
        this(impl, chat);
        setText(text);
    }

    @Override
    public Chat getChat() {
        return chat;
    }

    @Override
    public TelegramSendMessage setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public TelegramSendMessage setReplayTo(SnetUID messageId) {
        if (messageId != null)
            SnetUID.checkImpl(messageId, TelegramSocialNetwork.class);
        replayTo = messageId;
        return this;
    }

    @Override
    public SnetUID getReplayTo() {
        return replayTo;
    }

    @Override
    public boolean isMessageEditing() {
        return editingMessageId != null;
    }

    @Override
    public SnetUID getEditingMessageId() {
        return editingMessageId;
    }

    @Override
    public boolean isAttachmentsSupported() {
        return true;
    }

    @Override
    public TelegramSendMessage appendAttachments(Attachment... attachment) {
        // TODO
        return this;
    }

    @Override
    public TelegramSendMessage appendAttachments(Collection<Attachment> attachments) {
        // TODO
        return this;
    }

    @Override
    public List<Attachment> getAttachments() {
        // TODO
        return null;
    }

    @Override
    public Collection<Attachment> getAttachmentsByType(Class<? extends Attachment> type) {
        // TODO
        return null;
    }

    @Override
    public void removeAttachment(Attachment attachment) {
        // TODO
    }

    @Override
    public void send() {
        // TODO
    }
}
