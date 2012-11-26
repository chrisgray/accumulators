package org.chrisgray.accumulators.core.mean;

import org.chrisgray.accumulators.core.DoubleWeightedAccumulator;

public class MeanAccumulator extends DoubleWeightedAccumulator {
    private double count = 0;
    private double total = 0;

    @Override
    public void accumulate(double value) {
        accumulate(value, 1);
    }

    @Override
    public void accumulate(double value, double weight) {
        count += weight;
        total += value * weight;
    }

    @Override
    public double result() {
        if (count == 0) {
            throw new IllegalStateException("No mean has been accumulated.");
        } else {
            return total / count;
        }
    }
}