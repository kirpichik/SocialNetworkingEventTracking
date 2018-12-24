package org.polushin.snet.api;

import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

public abstract class AbstractChat<N extends SocialNetwork> implements Chat {

    protected final N implementation;

    private final ReentrantLock lock = new ReentrantLock();

    private volatile ChatLocker locker;

    public AbstractChat(N implementation) {
        this.implementation = implementation;
    }

    @Override
    public boolean tryLock(ChatLocker locker) {
        if (lock.tryLock()) {
            setLocker(locker);
            return true;
        }
        return false;
    }

    @Override
    public void lock(ChatLocker locker) throws InterruptedException {
        lock.lockInterruptibly();
        setLocker(locker);
    }

    @Override
    public boolean isLocked() {
        return lock.isLocked();
    }

    @Override
    public void unlock() {
        try {
            locker.onUnlock(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        locker = null;
        implementation.unlockChat(this);

        lock.unlock();
    }

    @Override
    public ChatLocker getLocker() {
        return locker;
    }

    private void setLocker(ChatLocker locker) {
        Objects.requireNonNull(locker, "Chat locker cannot be null!");
        this.locker = locker;
        try {
            locker.onLock(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        implementation.lockChat(this, locker);
    }
}
