package com.chrisgray.accumulators.core.atomic;

import com.chrisgray.accumulators.core.DoubleWeightedAccumulator;
import com.google.common.util.concurrent.AtomicDouble;

public class AtomicMeanAccumulator extends DoubleWeightedAccumulator {
    private final AtomicDouble count = new AtomicDouble();
    private final AtomicDouble total = new AtomicDouble();

    @Override
    public void accumulate(double value, double weight) {
        count.addAndGet(weight);
        total.addAndGet(value * weight);
    }

    @Override
    public void accumulate(double value) {
        accumulate(value, 1);
    }

    @Override
    public double result() {
        final double staticCount = count.get();
        if (staticCount == 0) {
            throw new IllegalStateException("No mean has been accumulated.");
        } else {
            return total.get() / staticCount;
        }
    }
}
