package org.chrisgray.accumulators.core.atomic.tests;

import org.chrisgray.accumulators.core.atomic.AtomicDoubleMaxAccumulator;
import org.chrisgray.accumulators.core.max.tests.DoubleMaxAccumulatorTest;
import org.junit.Before;

public class AtomicDoubleMaxAccumulatorTest extends DoubleMaxAccumulatorTest {
    @Override
    @Before
    public void setup() {
        accumulator = new AtomicDoubleMaxAccumulator();
    }
}
