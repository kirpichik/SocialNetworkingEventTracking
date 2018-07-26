package org.polushin.snet;

import com.sun.istack.internal.NotNull;
import org.polushin.snet.api.EventTracker;
import org.polushin.snet.api.SnetState;
import org.polushin.snet.api.SocialNetwork;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PluginsClassLoader extends ClassLoader {

    public final File SOCIAL_NETWORKS_DIR = new File("social_networks");
    public final File EVENT_TRACKERS_DIR = new File("event_trackers");

    private final Map<URL, SocialNetworksClassLoader> socialNetworksClassLoaders = new HashMap<>();

    public SocialNetwork loadSocialNetworkPlugin(@NotNull String name, @NotNull SnetState state) throws
            MalformedURLException {
        Objects.requireNonNull(name, "Name cannot be null!");
        Objects.requireNonNull(state, "State cannot be null!");

        URL url = formURL(SOCIAL_NETWORKS_DIR, name);
        SocialNetworksClassLoader classLoader;
        socialNetworksClassLoaders.put(url, classLoader = new SocialNetworksClassLoader(url));

        return classLoader.createInstance(state);
    }

    public EventTracker loadEventTrackerPlugin(@NotNull String name, @NotNull SnetState state) throws
            MalformedURLException {
        Objects.requireNonNull(name, "Name cannot be null!");
        Objects.requireNonNull(state, "State cannot be null!");

        return new EventTrackersClassLoader(formURL(EVENT_TRACKERS_DIR, name), this).createInstance(state);
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        for (SocialNetworksClassLoader classLoader : socialNetworksClassLoaders.values())
            try {
                return classLoader.loadClass(name);
            } catch (ClassNotFoundException ignored) {
            }
        throw new ClassNotFoundException(name);
    }

    private URL formURL(File dir, String name) throws MalformedURLException {
        if (!name.toLowerCase().endsWith(".jar"))
            name += ".jar";
        name += "!/";

        return new URL("jar", "", new File(SOCIAL_NETWORKS_DIR, name).getAbsolutePath());
    }

}
