package me.hupeng.hadop.day02.main;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable>{

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, LongWritable>.Context context)
			throws IOException, InterruptedException {
		//get a line
		String line = value.toString();
		String[] words = line.split(" ");
		
		for(String word: words){
			context.write(new Text(word), new LongWritable(1));
		}
		
	}
	
}
