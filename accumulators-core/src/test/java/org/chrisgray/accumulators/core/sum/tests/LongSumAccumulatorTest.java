package org.chrisgray.accumulators.core.sum.tests;

import com.google.common.collect.ImmutableList;
import org.chrisgray.accumulators.core.LongAccumulator;
import org.chrisgray.accumulators.core.sum.LongSumAccumulator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LongSumAccumulatorTest {
    protected LongAccumulator accumulator;

    @Before
    public void setup() {
        accumulator = new LongSumAccumulator();
    }

    @After
    public void tearDown() {
        accumulator = null;
    }

    @Test
    public void none() {
        assertThat(accumulator.result(), is(0L));
    }

    @Test
    public void one() {
        accumulator.accumulate(5L);
        assertThat(accumulator.result(), is(5L));
    }

    @Test
    public void sumAccumulatorWorks() {
        for(Integer i : ImmutableList.of(1, 4, -1, 3, 2)) {
            accumulator.accumulate(i.longValue());
        }
        assertThat(accumulator.result(), is(9L));
    }

    @Test
    public void overrideDefault() {
        assertThat(new LongSumAccumulator(5L).result(), is(5L));

        accumulator = new LongSumAccumulator(6L);
        accumulator.accumulate(2L);
        assertThat(accumulator.result(), is(8L));
    }

    @Test
    public void defaultValue() {
        assertThat(new LongSumAccumulator(-1L).result(), is(-1L));
    }
}