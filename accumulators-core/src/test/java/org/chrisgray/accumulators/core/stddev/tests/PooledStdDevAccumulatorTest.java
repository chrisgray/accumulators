package org.chrisgray.accumulators.core.stddev.tests;

import com.google.common.collect.ImmutableList;
import org.chrisgray.accumulators.core.DoubleWeightedAccumulator;
import org.chrisgray.accumulators.core.stddev.PooledStdDevAccumulator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PooledStdDevAccumulatorTest {
    protected DoubleWeightedAccumulator accumulator;

    @Before
    public void setup() {
        accumulator = new PooledStdDevAccumulator();
    }

    @After
    public void tearDown() {
        accumulator = null;
    }

    @Test(expected = IllegalStateException.class)
    public void none() {
        assertThat(accumulator.result(), is(0.0));
    }

    @Test
    public void one() {
        accumulator.accumulate(1.1, 12345);
        assertThat(accumulator.result(), is(1.1));
    }

    @Test(expected = IllegalStateException.class)
    public void pooledWithSingleSizedSets() {
        for (Double d : ImmutableList.of(1.0, 1.1, 2.3, 2.4, 3.0))
            accumulator.accumulate(d, 1);
        accumulator.result();
    }

    @Test
    public void pooledWithWeights() {
        final ImmutableList<Double> stdDevs = ImmutableList.of(1.0, 1.1, 2.3, 2.4, 3.0);
        final ImmutableList<Integer> samples = ImmutableList.of(1, 5, 9, 3, 4);

        assertThat(stdDevs.size(), equalTo(samples.size()));

        final Iterator<Double> stdDevsIterator = stdDevs.iterator();
        final Iterator<Integer> samplesIterator = samples.iterator();
        while (stdDevsIterator.hasNext() && samplesIterator.hasNext())
            accumulator.accumulate(stdDevsIterator.next(), samplesIterator.next());

        assertThat(accumulator.result(), is(2.2449944320643644));
    }

    @Test
    public void sample1() {
        final Iterator<Double> stdDeviations = ImmutableList.of(5.7, 4.3).iterator();
        final Iterator<Integer> sizes = ImmutableList.of(16, 9).iterator();
        while (stdDeviations.hasNext() && sizes.hasNext()) {
            accumulator.accumulate(stdDeviations.next(), sizes.next());
        }
        assertThat(accumulator.result(), is(5.255514701968656));
    }

    @Test
    public void wikipedia() {
        final Iterator<Double> stdDeviations = ImmutableList.of(1.0, 1.29, 2.12, 2.07, 1.58).iterator();
        final Iterator<Integer> sizes = ImmutableList.of(3, 4, 2, 5, 5).iterator();
        while (stdDeviations.hasNext() && sizes.hasNext()) {
            accumulator.accumulate(stdDeviations.next(), sizes.next());
        }
        assertThat(accumulator.result(), is(1.660720583705416));
    }
}