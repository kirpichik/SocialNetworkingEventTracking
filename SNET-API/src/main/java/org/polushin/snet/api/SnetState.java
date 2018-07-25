package org.polushin.snet.api;

import com.sun.istack.internal.NotNull;
import org.polushin.snet.api.actions.ChatAction;
import org.polushin.snet.api.actions.CommandAction;

import java.util.*;

public class SnetState {

    private final Map<Class<? extends SocialNetwork>, SocialNetwork> socialNetworks = new HashMap<>();
    private final Set<EventTracker> trackers = new HashSet<>();

    private final Set<MessageHandler> messageHandlers = new HashSet<>();
    private final Set<ChatActionHandler> actionHandlers = new HashSet<>();
    private final Map<String, CommandHandler> commands = new HashMap<>();

    public void addMessageHandler(@NotNull MessageHandler handler) {
        Objects.requireNonNull(handler, "Handler cannot be null!");

        messageHandlers.add(handler);
    }

    public void removeMessageHandler(@NotNull MessageHandler handler) {
        Objects.requireNonNull(handler, "Handler cannot be null!");

        messageHandlers.remove(handler);
    }

    public void addActionHandler(@NotNull ChatActionHandler handler) {
        Objects.requireNonNull(handler, "Handler cannot be null!");

        actionHandlers.add(handler);
    }

    public void removeActionHandler(@NotNull ChatActionHandler handler) {
        Objects.requireNonNull(handler, "Handler cannot be null!");

        actionHandlers.remove(handler);
    }

    public void setCommandHandler(@NotNull String commandName, @NotNull CommandHandler handler) {
        Objects.requireNonNull(commandName, "Command name cannot be null!");
        Objects.requireNonNull(handler, "Handler cannot be null!");

        commands.put(commandName, handler);
    }

    public void removeCommandHandler(@NotNull String commandName) {
        Objects.requireNonNull(commandName, "Command name cannot be null!");

        commands.remove(commandName);
    }

    public <T extends SocialNetwork> boolean registerSocialNetwork(@NotNull Class<T> clazz, @NotNull T socialNetwork) {
        Objects.requireNonNull(clazz, "Class cannot be null!");
        Objects.requireNonNull(socialNetwork, "Implementation cannot be null!");

        SocialNetwork old = socialNetworks.put(clazz, socialNetwork);
        if (old != null)
            old.destroy();
        return old == null;
    }

    public boolean registerTracker(@NotNull EventTracker tracker) {
        Objects.requireNonNull(tracker, "Tracker cannot be null!");

        return trackers.add(tracker);
    }

    public void performUpdate(@NotNull Message message) {
        Objects.requireNonNull(message, "Message cannot be null!");

        try {
            messageHandlers.forEach(handler -> handler.onMessage(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void performUpdate(@NotNull ChatAction action) {
        Objects.requireNonNull(action, "Chat action cannot be null!");

        try {
            actionHandlers.forEach(handler -> handler.onAction(action));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void performUpdate(@NotNull CommandAction command) {
        Objects.requireNonNull(command, "Command action cannot be null!");

        CommandHandler handler = commands.get(command.getCommandName());
        if (handler != null)
            try {
                handler.onCommand(command);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

}
