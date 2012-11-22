package com.chrisgray.accumulators.core.sum.tests;

import com.chrisgray.accumulators.core.DoubleAccumulator;
import com.chrisgray.accumulators.core.sum.DoubleSumAccumulator;
import com.google.common.collect.ImmutableList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DoubleSumAccumulatorTest {
    protected DoubleAccumulator accumulator;
    
    @Before
    public void setup() {
        accumulator = new DoubleSumAccumulator();
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
        accumulator.accumulate(5.0);
        assertThat(accumulator.result(), is(5.0));
    }
    
    @Test
    public void sumAccumulatorWorks() {
        for(Integer i : ImmutableList.of(1, 4, -1, 3, 2)) {
            accumulator.accumulate(i.doubleValue());
        }
        assertThat(accumulator.result(), is(9d));
    }

    @Test
    public void overrideDefault() {
        assertThat(new DoubleSumAccumulator(5.0).result(), is(5.0));

        accumulator = new DoubleSumAccumulator(6.0);
        accumulator.accumulate(2.1);
        assertThat(accumulator.result(), is(8.1));
    }

    @Test
    public void defaultValue() {
        assertThat(new DoubleSumAccumulator(-1.0).result(), is(-1.0));
    }
}
