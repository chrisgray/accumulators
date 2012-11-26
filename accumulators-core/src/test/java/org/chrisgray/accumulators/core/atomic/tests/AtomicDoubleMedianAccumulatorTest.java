package org.chrisgray.accumulators.core.atomic.tests;

import org.chrisgray.accumulators.core.atomic.AtomicMedianAccumulator;
import org.chrisgray.accumulators.core.median.tests.DoubleMedianAccumulatorTest;
import org.junit.Before;

public class AtomicDoubleMedianAccumulatorTest extends DoubleMedianAccumulatorTest {
    @Override
    @Before
    public void setup() {
        accumulator = new AtomicMedianAccumulator<Double>();
    }
}
