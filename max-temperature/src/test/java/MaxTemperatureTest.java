import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by qmcheng on 2017/11/9 0009.
 */
public class MaxTemperatureTest {
  private Mapper map;
  private MapDriver mapDriver;

  private Reducer reduce;
  private ReduceDriver reduceDriver;

  private MapReduceDriver mapReduceDriver;

  @Before
  @SuppressWarnings("unchecked")
  public void setup() {
    map = new MaxTemperature.MaxTemperatureMapper();
    mapDriver = new MapDriver(map);

    reduce = new MaxTemperature.MaxTemperatureReducer();
    reduceDriver = new ReduceDriver(reduce);

    mapReduceDriver = MapReduceDriver.newMapReduceDriver(map, reduce);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testMap() throws IOException {
    mapDriver.withInput(new LongWritable(), new Text("45007 2017 10 10 0 31.3000 999999.0000"))
        .withOutput(new Text("2017/10/10"), new DoubleWritable(31.3)).runTest();
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testReduce() {
    List<DoubleWritable> values = new ArrayList<>();
    values.add(new DoubleWritable(31.3));
    values.add(new DoubleWritable(17.7));
    values.add(new DoubleWritable(17.8));
    reduceDriver.withInput(new Text("2017/10/10"), values).withOutput(new Text("2017/10/10"), new DoubleWritable(31.3))
        .runTest();
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testMapReduce() {
    mapReduceDriver.withInput(new LongWritable(), new Text("45007 2017 10 10 0 31.3000 999999.0000"))
        .withInput(new LongWritable(), new Text("45007 2017 10 10 0 17.8000 999999.0000"))
        .withInput(new LongWritable(), new Text("45007 2017 10 10 1 17.7000 999999.0000"))
        .withOutput(new Text("2017/10/10"), new DoubleWritable(31.3)).runTest();
  }
}
