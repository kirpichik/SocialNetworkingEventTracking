package org.polushin.snet.api;

import org.polushin.snet.api.actions.ChatAction;
import org.polushin.snet.api.actions.CommandAction;

import java.util.*;

public class SnetState {

    private final Map<Class<? extends SocialNetwork>, SocialNetwork> socialNetworks = new HashMap<>();
    private final Set<EventTracker> trackers = new HashSet<>();

    private final Set<MessageHandler> messageHandlers = new HashSet<>();
    private final Set<ChatActionHandler> actionHandlers = new HashSet<>();
    private final Map<String, CommandHandler> commands = new HashMap<>();

    /**
     * Stops all input messages handling.
     */
    public void stop() {
        for (SocialNetwork network : socialNetworks.values()) {
            try {
                network.destroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (EventTracker tracker : trackers) {
            try {
                tracker.onDisable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Adds message handler.
     *
     * @param handler New handler.
     */
    public void addMessageHandler(MessageHandler handler) {
        Objects.requireNonNull(handler, "Handler cannot be null!");

        messageHandlers.add(handler);
    }

    /**
     * Removes message handler.
     *
     * @param handler Handler.
     */
    public void removeMessageHandler(MessageHandler handler) {
        Objects.requireNonNull(handler, "Handler cannot be null!");

        messageHandlers.remove(handler);
    }

    /**
     * Adds action handler.
     *
     * @param handler New handler.
     */
    public void addActionHandler(ChatActionHandler handler) {
        Objects.requireNonNull(handler, "Handler cannot be null!");

        actionHandlers.add(handler);
    }

    /**
     * Removes action handler.
     *
     * @param handler Handler.
     */
    public void removeActionHandler(ChatActionHandler handler) {
        Objects.requireNonNull(handler, "Handler cannot be null!");

        actionHandlers.remove(handler);
    }

    /**
     * Sets command handler.
     *
     * @param commandName Name of command.
     * @param handler New handler.
     */
    public void setCommandHandler(String commandName, CommandHandler handler) {
        Objects.requireNonNull(commandName, "Command name cannot be null!");
        Objects.requireNonNull(handler, "Handler cannot be null!");

        commands.put(commandName, handler);
    }

    /**
     * Removes command handler.
     *
     * @param commandName Name of command.
     */
    public void removeCommandHandler(String commandName) {
        Objects.requireNonNull(commandName, "Command name cannot be null!");

        commands.remove(commandName);
    }

    /**
     * Registers social network implementation.
     *
     * @param clazz Social Network class type.
     * @param socialNetwork Instance of social network.
     * @param <T> Social Network type.
     *
     * @throws IllegalStateException If this network type already registered.
     */
    public <T extends SocialNetwork> void registerSocialNetwork(Class<T> clazz, T socialNetwork) {
        Objects.requireNonNull(clazz, "Class cannot be null!");
        Objects.requireNonNull(socialNetwork, "Implementation cannot be null!");

        SocialNetwork old = socialNetworks.get(clazz);
        if (old != null)
            throw new IllegalStateException("This Social Network class already registered!");

        socialNetworks.put(clazz, socialNetwork);
    }

    /**
     * Registers new event tracker.
     *
     * @param tracker New tracker.
     *
     * @throws IllegalStateException If this tracker instance already registered.
     */
    public void registerTracker(EventTracker tracker) {
        Objects.requireNonNull(tracker, "Tracker cannot be null!");

        addActionHandler(tracker);
        addMessageHandler(tracker);

        if (!trackers.add(tracker))
            throw new IllegalStateException("This event tracker already registered!");
    }

    /**
     * Sends an update to all registered handlers.
     *
     * @param message Message update.
     */
    public void performUpdate(Message message) {
        Objects.requireNonNull(message, "Message cannot be null!");

        try {
            messageHandlers.forEach(handler -> handler.onMessage(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends an update to all registered handlers.
     *
     * @param action Action update.
     */
    public void performUpdate(ChatAction action) {
        Objects.requireNonNull(action, "Chat action cannot be null!");

        try {
            actionHandlers.forEach(handler -> handler.onAction(action));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends an update to all registered handlers.
     *
     * @param command Input command update.
     */
    public void performUpdate(CommandAction command) {
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
