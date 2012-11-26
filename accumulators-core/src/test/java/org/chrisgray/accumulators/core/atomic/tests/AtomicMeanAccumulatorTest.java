package org.chrisgray.accumulators.core.atomic.tests;

import org.chrisgray.accumulators.core.atomic.AtomicMeanAccumulator;
import org.chrisgray.accumulators.core.mean.tests.MeanAccumulatorTest;
import org.junit.Before;

public class AtomicMeanAccumulatorTest extends MeanAccumulatorTest {
    @Override
    @Before
    public void setup() {
        accumulator = new AtomicMeanAccumulator();
    }
}
