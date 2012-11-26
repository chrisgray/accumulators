package org.chrisgray.accumulators.core;

import com.google.common.base.Optional;

public abstract class DoubleAccumulator {
    public abstract void accumulate(double value);

    public void accumulate(Optional<Double> value) {
        if (value.isPresent()) {
            accumulate(value.get());
        }
    }

    public abstract double result();
}