package org.chrisgray.accumulators.core.atomic.tests;

import org.chrisgray.accumulators.core.atomic.AtomicStdDevAccumulator;
import org.chrisgray.accumulators.core.stddev.tests.StdDevAccumulatorTest;
import org.junit.Before;

public class AtomicStdDevAccumulatorTest extends StdDevAccumulatorTest {
    @Override
    @Before
    public void setup() {
        accumulator = new AtomicStdDevAccumulator();
    }
}
