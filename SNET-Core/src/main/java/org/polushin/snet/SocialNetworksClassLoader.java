package org.polushin.snet;

import org.polushin.snet.api.SnetState;
import org.polushin.snet.api.SocialNetwork;

import java.net.URL;
import java.net.URLClassLoader;

public class SocialNetworksClassLoader extends URLClassLoader {

    public SocialNetworksClassLoader(URL url) {
        super(new URL[] {url});
    }

    public SocialNetwork createInstance(SnetState state) {
        return null;
    }
}
