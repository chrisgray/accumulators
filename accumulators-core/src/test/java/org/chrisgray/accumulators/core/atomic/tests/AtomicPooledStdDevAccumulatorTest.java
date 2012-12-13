package org.chrisgray.accumulators.core.atomic.tests;

import org.chrisgray.accumulators.core.atomic.AtomicPooledStdDevAccumulator;
import org.chrisgray.accumulators.core.stddev.tests.PooledStdDevAccumulatorTest;
import org.junit.Before;

public class AtomicPooledStdDevAccumulatorTest extends PooledStdDevAccumulatorTest {
    @Override
    @Before
    public void setup() {
        accumulator = new AtomicPooledStdDevAccumulator();
    }
}
