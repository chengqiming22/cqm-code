#!/usr/bin/env bash

export HADOOP_CLASSPATH=~/code/cqm-code/max-temperature/target/max-temperature-1.0.0.jar
hadoop fs -rm -r -f /output
hadoop MaxTemperature /input /output
hadoop fs -cat /output/part-r-00000