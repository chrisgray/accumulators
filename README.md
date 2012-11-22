#Accumulators
I needed accumulators that needed to do basic accumulation for sum, mean, min, max, median, standard deviation (pooled), and smoothing (exponential).
I wanted to have an easy way to interface with the accumulators and also have concurrent options. In addition the simple interface, I also wanted to be sure to
use primitive types for performance. Right now the library only supports long/double options, but it can easily be extended to support the other numeric types.

##Sum

Currently supports primitive longs and doubles

    LongAccumulator sum = new LongSumAccumulator();
    sum.accumulate(5L);
    sum.accumulate(6L);
    sum.result(); //11L

    DoubleAccumulator sum = new DoubleSumAccumulator();
    sum.accumulate(5.0);
    sum.accumulate(6.1);
    sum.result(); //11.1