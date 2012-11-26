package org.chrisgray.accumulators.core.stddev;

import org.chrisgray.accumulators.core.DoubleWeightedAccumulator;

public class StdDevAccumulator extends DoubleWeightedAccumulator {
    private double pooledStdDev = 0;
    private int k = 0;
    private double n = 0;

    @Deprecated
    @Override
    public void accumulate(double s) {
        throw new IllegalArgumentException("Not supported, need a sample size");
    }

    @Override
    public void accumulate(double s, double size) {
        pooledStdDev += (size - 1) * (s * s);
        n += size;
        k++;
    }

    @Override
    public double result() {
        if (n <= 0 || (n - k <= 0)) {
            throw new IllegalStateException("Standard deviation calculation will result in a divide-by-zero exception");
        } else {
            return Math.sqrt(pooledStdDev / (n - k));
        }
    }
}