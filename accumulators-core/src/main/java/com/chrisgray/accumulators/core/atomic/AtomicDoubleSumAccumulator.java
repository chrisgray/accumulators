package com.chrisgray.accumulators.core.atomic;

import com.chrisgray.accumulators.core.DoubleAccumulator;
import com.google.common.util.concurrent.AtomicDouble;

public class AtomicDoubleSumAccumulator extends DoubleAccumulator {
    private AtomicDouble sum = new AtomicDouble();

    @Override
    public void accumulate(double value) {
        sum.addAndGet(value);
    }

    @Override
    public double result() {
        return sum.get();
    }
}