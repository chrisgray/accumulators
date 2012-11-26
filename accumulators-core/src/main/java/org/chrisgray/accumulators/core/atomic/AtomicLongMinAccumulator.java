package org.chrisgray.accumulators.core.atomic;

import org.chrisgray.accumulators.core.LongAccumulator;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongMinAccumulator extends LongAccumulator {
    private final AtomicLong min = new AtomicLong(Long.MAX_VALUE);
    private boolean set = false;

    public AtomicLongMinAccumulator() {}

    public AtomicLongMinAccumulator(long value) {
        accumulate(value);
    }

    @Override
    public void accumulate(long value) {
        boolean done = false;
        while (!done) {
            final long currentValue = min.get();
            done = min.compareAndSet(currentValue, Math.min(currentValue, value));
        }
        set = true;
    }

    @Override
    public long result() {
        if (set) {
            return min.get();
        } else {
            throw new IllegalStateException("No min has been accumulated");
        }
    }
}