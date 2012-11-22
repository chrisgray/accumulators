package com.chrisgray.accumulators.core.atomic.tests;

import com.chrisgray.accumulators.core.atomic.AtomicMedianAccumulator;
import com.chrisgray.accumulators.core.median.tests.DoubleMedianAccumulatorTest;
import org.junit.Before;

public class AtomicDoubleMedianAccumulatorTest extends DoubleMedianAccumulatorTest {
    @Override
    @Before
    public void setup() {
        accumulator = new AtomicMedianAccumulator<Double>();
    }
}
