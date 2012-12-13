package org.chrisgray.accumulators.core.atomic;

import com.google.common.util.concurrent.AtomicDouble;
import org.chrisgray.accumulators.core.DoubleWeightedAccumulator;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicPooledStdDevAccumulator extends DoubleWeightedAccumulator {
    private AtomicDouble pooledStdDev = new AtomicDouble();
    private AtomicInteger k = new AtomicInteger();
    private AtomicDouble n = new AtomicDouble();

    @Override
    public void accumulate(double s, double size) {
        pooledStdDev.addAndGet((size - 1) * (s * s));
        n.addAndGet(size);
        k.incrementAndGet();
    }

    @Deprecated
    @Override
    public void accumulate(double s) {
        throw new IllegalArgumentException("Not supported, need a sample size");
    }

    @Override
    public double result() {
        final double staticN = n.get();
        final double staticK = k.get();
        if (staticN <= 0 || (staticN - staticK <= 0)) {
            throw new IllegalStateException("Standard deviation calculation will result in a divide-by-zero exception");
        } else {
            return Math.sqrt(pooledStdDev.get() / (staticN - staticK));
        }
    }
}
