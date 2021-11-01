package cmbnt;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Limiter {

    private final AtomicInteger maxCount;
    private final AtomicInteger lock = new AtomicInteger(0);

    public Limiter(final int initMaxCount, long perSecond) {
        this.maxCount = new AtomicInteger(initMaxCount);
        Executors.newScheduledThreadPool(1).schedule(() -> {
            for (; ; ) {
                if (getLock()) {
                    try {
                        if (maxCount.get() == initMaxCount) { // [1]
                            return;
                        }
                        maxCount.incrementAndGet(); // [2]
                    } finally {
                        releaseLock();
                    }
                }
            }
        }, perSecond, TimeUnit.SECONDS);
    }

    public boolean acquire() {
        for (; ; ) {
            if (getLock()) {
                try {
                    if (maxCount.get() > 0) {
                        maxCount.decrementAndGet(); // [3]
                        return true;
                    } else {
                        return false;
                    }
                } finally {
                    releaseLock();
                }
            }
        }
    }

    private boolean getLock() {
        return lock.compareAndSet(0, 1); // [4]
    }

    private void releaseLock() {
        lock.set(0); // [5]
    }
}
