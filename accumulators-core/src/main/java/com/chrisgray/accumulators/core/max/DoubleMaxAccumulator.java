package com.chrisgray.accumulators.core.max;

import com.chrisgray.accumulators.core.DoubleAccumulator;

public class DoubleMaxAccumulator extends DoubleAccumulator {
    protected double max = Double.MIN_VALUE;
    protected boolean set = false;

    public DoubleMaxAccumulator() {
    }

    public DoubleMaxAccumulator(double max) {
        accumulate(max);
    }

    @Override
    public void accumulate(double value) {
        if (set) {
            max = Math.max(max, value);
        } else {
            max = value;
            set = true;
        }
    }

    @Override
    public double result() {
        if (set) {
            return max;
        } else {
            throw new IllegalStateException("No max has been accumulated");
        }
    }
}
