package org.chrisgray.accumulators.core.atomic;

import com.google.common.util.concurrent.AtomicDouble;
import org.chrisgray.accumulators.core.DoubleAccumulator;

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