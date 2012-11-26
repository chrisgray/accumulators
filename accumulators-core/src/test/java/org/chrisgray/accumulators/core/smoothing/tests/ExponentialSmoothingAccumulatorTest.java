package org.chrisgray.accumulators.core.smoothing.tests;

import com.google.common.base.Optional;
import org.chrisgray.accumulators.core.DoubleWeightedAccumulator;
import org.chrisgray.accumulators.core.smoothing.ExponentialSmoothingAccumulator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ExponentialSmoothingAccumulatorTest {
    protected DoubleWeightedAccumulator accumulator;

    @Before
    public void setup() {
        final double alpha = 0.75;
        accumulator = new ExponentialSmoothingAccumulator(alpha);
    }

    @After
    public void tearDown() {
        accumulator = null;
    }

    @Test
    public void none() {
        assertThat(accumulator.result(), is(0.0));
    }

    @Test
    public void one() {
        accumulator.accumulate(1.7, 0.8);
        assertThat(accumulator.result(), is(1.7 * 0.8));
    }

    @Test
    public void three() {
        accumulator.accumulate(1.7, 0.8);
        accumulator.accumulate(2.2, 1.0);
        accumulator.accumulate(2.0, 0.92);
        assertThat(accumulator.result(), is(1.8775000000000002));
    }

    @Test
    public void nullValues() {
        accumulator.accumulate(Optional.<Double>absent(), 0.5);
        assertThat(accumulator.result(), is(0.0));
    }
}
