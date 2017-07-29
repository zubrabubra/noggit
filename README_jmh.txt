How to run JMH tests:
mvn install -Pjmh

Latest results for comparison:
Benchmark                                                         Mode  Cnt        Score       Error   Units
SimpleBenchmark.simpleTestCore                                   thrpt  200  4259193.317 ± 38393.175   ops/s
SimpleBenchmark.simpleTestCore:·gc.alloc.rate                    thrpt  200     2120.341 ±    19.104  MB/sec
SimpleBenchmark.simpleTestCore:·gc.alloc.rate.norm               thrpt  200      784.000 ±     0.001    B/op
SimpleBenchmark.simpleTestCore:·gc.churn.PS_Eden_Space           thrpt  200     2119.441 ±    21.079  MB/sec
SimpleBenchmark.simpleTestCore:·gc.churn.PS_Eden_Space.norm      thrpt  200      783.710 ±     3.804    B/op
SimpleBenchmark.simpleTestCore:·gc.churn.PS_Survivor_Space       thrpt  200        0.194 ±     0.010  MB/sec
SimpleBenchmark.simpleTestCore:·gc.churn.PS_Survivor_Space.norm  thrpt  200        0.072 ±     0.004    B/op
SimpleBenchmark.simpleTestCore:·gc.count                         thrpt  200     4150.000              counts
SimpleBenchmark.simpleTestCore:·gc.time                          thrpt  200     1927.000                  ms
SimpleBenchmark.simpleTestOps                                    thrpt  200  6353975.392 ± 76349.733   ops/s
SimpleBenchmark.simpleTestOps:·gc.alloc.rate                     thrpt  200      258.212 ±     3.099  MB/sec
SimpleBenchmark.simpleTestOps:·gc.alloc.rate.norm                thrpt  200       64.000 ±     0.001    B/op
SimpleBenchmark.simpleTestOps:·gc.churn.PS_Eden_Space            thrpt  200      258.384 ±     3.458  MB/sec
SimpleBenchmark.simpleTestOps:·gc.churn.PS_Eden_Space.norm       thrpt  200       64.056 ±     0.485    B/op
SimpleBenchmark.simpleTestOps:·gc.churn.PS_Survivor_Space        thrpt  200        0.094 ±     0.007  MB/sec
SimpleBenchmark.simpleTestOps:·gc.churn.PS_Survivor_Space.norm   thrpt  200        0.023 ±     0.002    B/op
SimpleBenchmark.simpleTestOps:·gc.count                          thrpt  200     2513.000              counts
SimpleBenchmark.simpleTestOps:·gc.time                           thrpt  200     1295.000                  ms