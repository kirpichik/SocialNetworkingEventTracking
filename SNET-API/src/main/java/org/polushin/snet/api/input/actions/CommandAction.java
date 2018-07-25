package org.polushin.snet.api.input.actions;

import com.sun.istack.internal.NotNull;
import org.polushin.snet.api.input.Chat;
import org.polushin.snet.api.input.User;

import java.util.Objects;

public class CommandAction extends AbstractChatAction {

    public static final String COMMAND_PREFIX = "/";

    private final String commandName;
    private final String[] args;

    /**
     * @param messageId Command message ID.
     * @param from Command sender.
     * @param chat Chat, where command was sent.
     * @param date Time of sending a command.
     * @param text Plain message text.
     */
    public CommandAction(long messageId, @NotNull User from, @NotNull Chat chat, long date, @NotNull String text) {
        super(Type.COMMAND, messageId, from, chat, date, text);

        Objects.requireNonNull(from, "User cannot be null!");
        Objects.requireNonNull(text, "Command text cannot be null!");

        String[] split = text.substring(COMMAND_PREFIX.length()).split(" ");
        commandName = split[0];
        args = new String[split.length - 1];
        System.arraycopy(split, 1, args, 0, args.length);
    }

    /**
     * @return Command arguments.
     */
    public String[] getArgs() {
        return args;
    }

    /**
     * @return Name of command.
     */
    public String getCommandName() {
        return commandName;
    }
}
