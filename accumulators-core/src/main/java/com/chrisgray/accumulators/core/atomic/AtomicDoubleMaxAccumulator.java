package com.chrisgray.accumulators.core.atomic;

import com.chrisgray.accumulators.core.DoubleAccumulator;
import com.google.common.util.concurrent.AtomicDouble;

public class AtomicDoubleMaxAccumulator extends DoubleAccumulator {
    private final AtomicDouble max = new AtomicDouble(Double.MIN_VALUE);
    private boolean set = false;

    public AtomicDoubleMaxAccumulator() {}

    public AtomicDoubleMaxAccumulator(double value) {
        accumulate(value);
    }

    @Override
    public void accumulate(double value) {
        boolean done = false;
        while (!done) {
            final double currentValue = max.get();
            done = max.compareAndSet(currentValue, Math.max(currentValue, value));
        }
        set = true;
    }

    @Override
    public double result() {
        if (set) {
            return max.get();
        } else {
            throw new IllegalStateException("No max has been accumulated");
        }
    }
}