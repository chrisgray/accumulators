package com.chrisgray.accumulators.core.max.tests;

import com.chrisgray.accumulators.core.LongAccumulator;
import com.chrisgray.accumulators.core.max.LongMaxAccumulator;
import com.google.common.collect.ImmutableList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LongMaxAccumulatorTest {
    protected LongAccumulator accumulator;

    @Before
    public void setup() {
        accumulator = new LongMaxAccumulator();
    }

    @After
    public void tearDown() {
        accumulator = null;
    }

    @Test(expected = IllegalStateException.class)
    public void none() {
        assertThat(accumulator.result(), is(0L));
    }

    @Test
    public void multiple() {
        for(Integer i : ImmutableList.of(1, 4, -1, 3, 2)) {
            accumulator.accumulate(i.longValue());
        }
        assertThat(accumulator.result(), is(4L));
    }

    @Test
    public void overrideDefault() {
        assertThat(new LongMaxAccumulator(5L).result(), is(5L));

        accumulator = new LongMaxAccumulator(1L);
        accumulator.accumulate(2L);
        assertThat(accumulator.result(), is(2L));
    }

    @Test
    public void defaultValue() {
        assertThat(new LongMaxAccumulator(-1L).result(), is(-1L));
    }
}
