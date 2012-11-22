package com.chrisgray.accumulators.core.atomic.tests;

import com.chrisgray.accumulators.core.atomic.AtomicMeanAccumulator;
import com.chrisgray.accumulators.core.mean.tests.MeanAccumulatorTest;
import org.junit.Before;

public class AtomicMeanAccumulatorTest extends MeanAccumulatorTest {
    @Override
    @Before
    public void setup() {
        accumulator = new AtomicMeanAccumulator();
    }
}
