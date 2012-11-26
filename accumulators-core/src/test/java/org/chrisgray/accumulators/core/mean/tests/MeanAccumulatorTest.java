package org.chrisgray.accumulators.core.mean.tests;

import com.google.common.collect.ImmutableList;
import org.chrisgray.accumulators.core.DoubleWeightedAccumulator;
import org.chrisgray.accumulators.core.mean.MeanAccumulator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MeanAccumulatorTest {
    protected DoubleWeightedAccumulator accumulator;

    @Before
    public void setup() {
        accumulator = new MeanAccumulator();
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
        accumulator.accumulate(1.1);
        assertThat(accumulator.result(), is(1.1));
    }

    @Test
    public void meansAccumulate() {
        for(Integer i : ImmutableList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) {
            accumulator.accumulate(i.doubleValue());
        }
        assertThat(accumulator.result(), is(5.5));
    }

    @Test
    public void weightedMeansAccumulate() {
        final ImmutableList<Integer> items = ImmutableList.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final ImmutableList<Integer> weights = ImmutableList.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 10000, 1);
        assertThat("Weights and items lists are of the same size", items.size(), equalTo(weights.size()));

        final Iterator<Integer> itemsIterator = items.iterator();
        final Iterator<Integer> weightsIterator = weights.iterator();
        while (itemsIterator.hasNext() && weightsIterator.hasNext()) {
            accumulator.accumulate(itemsIterator.next().doubleValue(), weightsIterator.next());
        }

        assertThat("Weighted mean should be 5.0", accumulator.result(), is(8.995604395604396));
    }
}
