package org.chrisgray.accumulators.core.stddev;

import com.google.common.collect.Lists;
import org.chrisgray.accumulators.core.DoubleAccumulator;
import org.chrisgray.accumulators.core.mean.MeanAccumulator;

import java.util.List;

public class StdDevAccumulator extends DoubleAccumulator {
    private final List<Double> values = Lists.newArrayList();
    private final MeanAccumulator mean = new MeanAccumulator();

    @Override
    public void accumulate(double value) {
        values.add(value);
        mean.accumulate(value);
    }

    @Override
    public double result() {
        final MeanAccumulator variance = new MeanAccumulator();
        final double snapshotMean = mean.result();
        for (double value : values) {
            final double diff = snapshotMean - value;
            variance.accumulate(diff * diff);
        }
        return Math.sqrt(variance.result());
    }
}
