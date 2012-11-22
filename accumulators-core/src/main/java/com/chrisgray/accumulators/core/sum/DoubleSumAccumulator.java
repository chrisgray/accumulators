package com.chrisgray.accumulators.core.sum;

import com.chrisgray.accumulators.core.DoubleAccumulator;

public class DoubleSumAccumulator extends DoubleAccumulator {
    protected double sum = 0.0;

    public DoubleSumAccumulator() {
    }

    public DoubleSumAccumulator(double sum) {
        accumulate(sum);
    }

    @Override
    public void accumulate(double value) {
        sum += value;
    }

    @Override
    public double result() {
        return sum;
    }
}