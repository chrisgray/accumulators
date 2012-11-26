package org.chrisgray.accumulators.core.atomic.tests;

import org.chrisgray.accumulators.core.atomic.AtomicDoubleSumAccumulator;
import org.chrisgray.accumulators.core.sum.tests.DoubleSumAccumulatorTest;
import org.junit.Before;

public class AtomicDoubleSumAccumulatorTest extends DoubleSumAccumulatorTest {
    @Override
    @Before
    public void setup() {
        accumulator = new AtomicDoubleSumAccumulator();
    }
}