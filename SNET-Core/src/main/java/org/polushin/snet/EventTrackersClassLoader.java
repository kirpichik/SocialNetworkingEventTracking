package org.polushin.snet;

import org.polushin.snet.api.EventTracker;
import org.polushin.snet.api.SnetState;

import java.net.URL;
import java.net.URLClassLoader;

public class EventTrackersClassLoader extends URLClassLoader {

    public EventTrackersClassLoader(URL url, ClassLoader parent) {
        super(new URL[] {url}, parent);
    }

    public EventTracker createInstance(SnetState state) {
        return null;
    }
}
