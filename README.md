#Accumulators
I needed accumulators that needed to do basic accumulation for sum, mean, min, max, median, standard deviation (pooled), and smoothing (exponential).
I wanted to have an easy way to interface with the accumulators and also have concurrent options. In addition the simple interface, I also wanted to be sure to
use primitive types for performance. Right now the library only supports long/double options, but it can easily be extended to support the other numeric types.

##Sum
    LongAccumulator sum = new LongSumAccumulator();
    sum.accumulate(5L);
    sum.accumulate(6L);
    sum.result(); //11L

    DoubleAccumulator sum = new DoubleSumAccumulator();
    sum.accumulate(5.0);
    sum.accumulate(6.1);
    sum.result(); //11.1

##Mean
    MeanAccumulator mean = new MeanAccumulator();
    mean.accumulate(5L);
    mean.accumulate(6L);
    mean.result(); //5.5

##Min
    LongAccumulator min = new LongMinAccumulator();
    min.accumulate(5L);
    min.accumulate(6L);
    min.result(); //5L

    DoubleAccumulator min = new DoubleMinAccumulator();
    min.accumulate(5.0);
    min.accumulate(6.1);
    min.result(); //5.0

##Max
    LongAccumulator max = new LongMaxAccumulator();
    max.accumulate(5L);
    max.accumulate(6L);
    max.result(); //6L

    DoubleAccumulator max = new DoubleMaxAccumulator();
    max.accumulate(5.0);
    max.accumulate(6.1);
    max.result(); //6.1
    
##Median
    MedianAccumulator<Long> median = new MedianAccumulator<Double>();
    median.accumulate(5L);
    median.accumulate(6L);
    median.result(); //5.5

    MedianAccumulator<Long> median = new MedianAccumulator<Double>();
    median.accumulate(5.0);
    median.accumulate(6.0);
    median.accumulate(7.0);
    median.result(); //6.0

##Standard Deviation

Calculated using pooled standard deviation: http://en.wikipedia.org/wiki/Pooled_variance

    StdDevAccumulator stddev = new StdDevAccumulator();
    stddev.accumulate(1.0, 3); //where 1.0 = a standard deviation, for a sample-size of 3 (s = 1.0, n = 3)
    stddev.accumulate(1.29, 4);
    stddev.accumulate(2.12, 2);
    stddev.accumulate(2.07, 5);
    stddev.accumulate(1.58, 5);
    stddev.result(); //1.66 (1.660720583705416)

##Exponential Smoothing

Calculated using: http://en.wikipedia.org/wiki/Exponential_smoothing

##Weighted Accumulators

For certain accumulators: mean and exponential smoothing allow for weights to be applied with their values. This can be used as:

    DoubleWeightedAccumulator mean = new DoubleMeanAccumulator();
    max.accumulate(1L, 1L);
    max.accumulate(2l, 1L);
    max.accumulate(3l, 1L);
    max.accumulate(4l, 1000000L);
    max.accumulate(5l, 1L);
    max.result(); //very close to 4, because 4 is heavily weighted.

##Atomic Accumulators

Aim to use atomic wrappers in java.util.concurrent.atomic or more coarse-grain synchronization blocks in more complicated scenarios.
Besides their implementation they should be drop-in replacements.

    LongAccumulator max = new AtomicLongMaxAccumulator();
    max.accumulate(5L);
    max.accumulate(6L);
    max.result(); //6L