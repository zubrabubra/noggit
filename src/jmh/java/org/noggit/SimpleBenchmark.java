package org.noggit;

import org.openjdk.jmh.annotations.*;

import java.io.IOException;

@State(Scope.Benchmark)
public class SimpleBenchmark {

  JSONParserOpt parser = new JSONParserOpt("{'count': 1600}");

  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  public long simpleTestCore() throws IOException {
    JSONParser parser = new JSONParser("{'count': 1600}", 0, "{'count': 1600}".length());
    int i = parser.nextEvent();
    int j = parser.nextEvent();
    int k = parser.getString().hashCode();
    int sum = i + j + k + parser.nextEvent();

    parser = new JSONParser("{'count': 1600}", 0, "{'count': 1600}".length());
    i = parser.nextEvent();
    j = parser.nextEvent();
    k = parser.getString().hashCode();
    sum = sum + i + j + k + parser.nextEvent();

    return sum;
  }

  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  public long simpleTestOps() throws IOException {
    parser.reUse("{'count': 1600}", 0, "{'count': 1600}".length());
    int i = parser.nextEvent();
    int j = parser.nextEvent();
    int k = parser.getString().hashCode();
    int sum = i + j + k + parser.nextEvent();

    parser.reUse("{'count': 1600}", 0, "{'count': 1600}".length());
    i = parser.nextEvent();
    j = parser.nextEvent();
    k = parser.getString().hashCode();
    sum = sum + i + j + k + parser.nextEvent();

    return sum;
  }
}
