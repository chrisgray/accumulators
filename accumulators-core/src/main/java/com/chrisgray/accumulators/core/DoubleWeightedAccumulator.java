package com.chrisgray.accumulators.core;

import com.google.common.base.Optional;

public abstract class DoubleWeightedAccumulator extends DoubleAccumulator {
    public abstract void accumulate(double value, double weight);

    public void accumulate(Optional<Double> value, double weight) {
        if (value.isPresent()) {
            accumulate(value.get(), weight);
        }
    }
}
