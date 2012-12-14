package org.chrisgray.accumulators.core.atomic;

import com.google.common.collect.Lists;
import org.chrisgray.accumulators.core.DoubleAccumulator;
import org.chrisgray.accumulators.core.mean.MeanAccumulator;

import java.util.List;

public class AtomicStdDevAccumulator extends DoubleAccumulator {
    private final List<Double> values = Lists.newArrayList();
    private final AtomicMeanAccumulator mean = new AtomicMeanAccumulator();

    @Override
    public void accumulate(double value) {
        synchronized (this) {
            values.add(value);
        }
        mean.accumulate(value);
    }

    @Override
    public double result() {
        final MeanAccumulator variance = new MeanAccumulator();
        synchronized (this) {
            final double snapshotMean = mean.result();
            for (double value : values) {
                final double diff = snapshotMean - value;
                variance.accumulate(diff * diff);
            }
        }
        return Math.sqrt(variance.result());
    }
}
