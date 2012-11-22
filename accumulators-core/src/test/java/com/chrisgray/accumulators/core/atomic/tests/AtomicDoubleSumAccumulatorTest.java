package com.chrisgray.accumulators.core.atomic.tests;

import com.chrisgray.accumulators.core.atomic.AtomicDoubleSumAccumulator;
import com.chrisgray.accumulators.core.sum.tests.DoubleSumAccumulatorTest;
import org.junit.Before;

public class AtomicDoubleSumAccumulatorTest extends DoubleSumAccumulatorTest {
    @Override
    @Before
    public void setup() {
        accumulator = new AtomicDoubleSumAccumulator();
    }
}