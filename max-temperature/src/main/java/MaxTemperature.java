import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Created by qmcheng on 2017/11/9 0009.
 */
public class MaxTemperature {

  public static class MaxTemperatureMapper extends Mapper<LongWritable, Text, IntWritable, DoubleWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
      String line = value.toString();
      String[] parts = line.split(" ");
      if (parts.length == 7) {
        try {
          int year = Integer.parseInt(parts[1]);
          double temp = Double.parseDouble(parts[5]);
          context.write(new IntWritable(year), new DoubleWritable(temp));
        } catch (NumberFormatException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static class MaxTemperatureReducer extends Reducer<IntWritable, DoubleWritable, IntWritable, DoubleWritable> {
    @Override
    protected void reduce(IntWritable key, Iterable<DoubleWritable> values, Context context)
        throws IOException, InterruptedException {
      double max = Double.MIN_VALUE;
      for (DoubleWritable d : values) {
        max = Math.max(d.get(), max);
      }
      context.write(key, new DoubleWritable(max));
    }
  }

  public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
    Job job = Job.getInstance();
    job.setJobName("Max temperature");
    job.setJarByClass(MaxTemperature.class);

    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));

    job.setMapperClass(MaxTemperatureMapper.class);
    job.setReducerClass(MaxTemperatureReducer.class);

    job.setOutputKeyClass(IntWritable.class);
    job.setOutputValueClass(DoubleWritable.class);

    System.exit(job.waitForCompletion(true) ? 0 : 1);

  }
}
