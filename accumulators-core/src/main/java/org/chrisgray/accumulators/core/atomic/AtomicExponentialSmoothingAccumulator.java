package org.chrisgray.accumulators.core.atomic;

import org.chrisgray.accumulators.core.smoothing.ExponentialSmoothingAccumulator;

public class AtomicExponentialSmoothingAccumulator extends ExponentialSmoothingAccumulator {
    public AtomicExponentialSmoothingAccumulator(double alpha) {
        super(alpha);
    }

    @Override
    public synchronized void accumulate(double value, double weight) {
        super.accumulate(value, weight);
    }
}
