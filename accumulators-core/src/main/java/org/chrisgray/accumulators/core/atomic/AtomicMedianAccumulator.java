package org.chrisgray.accumulators.core.atomic;

import org.chrisgray.accumulators.core.median.MedianAccumulator;

public class AtomicMedianAccumulator<E extends Number & Comparable<E>> extends MedianAccumulator<E> {
    @Override
    public synchronized void accumulate(E value) {
        super.accumulate(value);
    }

    @Override
    public synchronized double result() {
        return super.result();
    }
}