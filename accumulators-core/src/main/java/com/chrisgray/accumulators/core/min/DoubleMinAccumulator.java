package com.chrisgray.accumulators.core.min;

import com.chrisgray.accumulators.core.DoubleAccumulator;

public class DoubleMinAccumulator extends DoubleAccumulator {
    protected double min = Double.MAX_VALUE;
    protected boolean set = false;

    public DoubleMinAccumulator() {
    }

    public DoubleMinAccumulator(double min) {
        accumulate(min);
    }

    public void accumulate(double value) {
        if (set) {
            min = Math.min(min, value);
        } else {
            min = value;
            set = true;
        }
    }

    public double result() {
        if (set) {
            return min;
        } else {
            throw new IllegalStateException("No min has been accumulated");
        }
    }
}