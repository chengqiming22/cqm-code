import com.cqm.hadoop.WordCount;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17-11-6.
 */
public class WordCountTest {

    private Mapper map;
    private MapDriver mapDriver;

    private Reducer reduce;
    private ReduceDriver reduceDriver;

    @Before
    @SuppressWarnings("unchecked")
    public void setup() {
        map = new WordCount.TokenizerMapper();
        mapDriver = new MapDriver(map);

        reduce = new WordCount.IntSumReducer();
        reduceDriver = new ReduceDriver(reduce);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testMap() throws IOException {
        String text = "hello world goodbye world hello hadoop goodbye hadoop";
        mapDriver.withInput(new LongWritable(), new Text(text))
                .withOutput(new Text("hello"), new IntWritable(1))
                .withOutput(new Text("world"), new IntWritable(1))
                .withOutput(new Text("goodbye"), new IntWritable(1))
                .withOutput(new Text("world"), new IntWritable(1))
                .withOutput(new Text("hello"), new IntWritable(1))
                .withOutput(new Text("hadoop"), new IntWritable(1))
                .withOutput(new Text("goodbye"), new IntWritable(1))
                .withOutput(new Text("hadoop"), new IntWritable(1)).runTest();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testReduce() {
        List<IntWritable> values = new ArrayList<>();
        values.add(new IntWritable(1));
        values.add(new IntWritable(1));
        reduceDriver.withInput(new Text("6"), values)
                .withOutput(new Text("6"), new IntWritable(2))
                .runTest();
    }
}
