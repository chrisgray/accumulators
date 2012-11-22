package com.chrisgray.accumulators.core.atomic;

import com.chrisgray.accumulators.core.LongAccumulator;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongMaxAccumulator extends LongAccumulator {
    private final AtomicLong max = new AtomicLong(Long.MIN_VALUE);
    private boolean set = false;

    public AtomicLongMaxAccumulator() {}

    public AtomicLongMaxAccumulator(long value) {
        accumulate(value);
    }

    @Override
    public void accumulate(long value) {
        boolean done = false;
        while (!done) {
            final long currentValue = max.get();
            done = max.compareAndSet(currentValue, Math.max(currentValue, value));
        }
        set = true;
    }

    @Override
    public long result() {
        if (set) {
            return max.get();
        } else {
            throw new IllegalStateException("No max has been accumulated");
        }
    }
}
