package com.chrisgray.accumulators.core.atomic;

import com.chrisgray.accumulators.core.DoubleAccumulator;
import com.google.common.util.concurrent.AtomicDouble;

public class AtomicDoubleMinAccumulator extends DoubleAccumulator {
    private final AtomicDouble min = new AtomicDouble(Double.MAX_VALUE);
    private boolean set = false;

    public AtomicDoubleMinAccumulator() {}

    public AtomicDoubleMinAccumulator(double value) {
        accumulate(value);
    }

    @Override
    public void accumulate(double value) {
        boolean done = false;
        while (!done) {
            final double currentValue = min.get();
            done = min.compareAndSet(currentValue, Math.min(currentValue, value));
        }
        set = true;
    }

    @Override
    public double result() {
        if (set) {
            return min.get();
        } else {
            throw new IllegalStateException("No min has been accumulated");
        }
    }
}
