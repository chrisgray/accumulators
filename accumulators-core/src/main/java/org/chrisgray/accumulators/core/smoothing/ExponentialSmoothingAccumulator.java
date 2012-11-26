package org.chrisgray.accumulators.core.smoothing;

import org.chrisgray.accumulators.core.DoubleWeightedAccumulator;

import static com.google.common.base.Preconditions.checkArgument;

public class ExponentialSmoothingAccumulator extends DoubleWeightedAccumulator {
    private final double alpha;
    private double previous = 0.0;
    private double current = 0.0;
    private boolean set = false;

    public ExponentialSmoothingAccumulator(double alpha) {
        this.alpha = alpha;
        checkArgument(alpha >= 0.0 && alpha <= 1.0, "alpha must be between 0.0 and 1.0 (%f)", alpha);
    }

    @Override
    public void accumulate(double value) {
        accumulate(value, 1);
    }

    @Override
    public void accumulate(double value, double weight) {
        if (set) {
            current = alpha * (value * weight) + (1 - alpha) * previous;
        } else {
            current = value * weight;
            set = true;
        }
        previous = current;
    }

    @Override
    public double result() {
        return current;
    }
}