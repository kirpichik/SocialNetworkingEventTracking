package org.polushin.snet.api;

import java.util.Objects;

public final class SnetUID {

    public static final SnetUID UNSPECIFIED = new SnetUID(-1, null);

    public final long localId;
    public final Class<? extends SocialNetwork> impl;

    private SnetUID(long localId, Class<? extends SocialNetwork> impl) {
        this.localId = localId;
        this.impl = impl;
    }

    public boolean isInSameSnet(SnetUID id) {
        Objects.requireNonNull(id, "UID cannot be null!");
        return id.impl == impl;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != SnetUID.class)
            return false;
        SnetUID o = (SnetUID) obj;
        return o.impl == impl && o.localId == localId;
    }

    @Override
    public int hashCode() {
        // FIXME - add impl to hash
        return Long.hashCode(localId);
    }

    public static SnetUID getId(long id, Class<? extends SocialNetwork> impl) {
        Objects.requireNonNull(impl, "Implementation cannot be null!");
        return new SnetUID(id, impl);
    }

    public static SnetUID parseId(String uid) {
        // TODO - parse id
        throw new UnsupportedOperationException("Not implemented");
    }

    public static void checkImpl(SnetUID uid, Class<? extends SocialNetwork> impl, String msg) throws IllegalArgumentException {
        Objects.requireNonNull(uid, "ID cannot be null!");
        Objects.requireNonNull(impl, "Implementation cannot be null!");
        if (uid.impl != impl)
            throw new IllegalArgumentException(msg);
    }

    public static void checkImpl(SnetUID uid, Class<? extends SocialNetwork> impl) throws IllegalArgumentException {
        checkImpl(uid, impl, "Invalid UID implementation!");
    }
}
