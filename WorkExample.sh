#!/bin/sh
testing='/home/sakshi/SparkData/Testing.txt'
tokens='/home/sakshi/SparkData/Tokenized'
Stop='/home/sakshi/SparkData/StopWords'
NoStop='/home/sakshi/SparkData/NoStopWords.csv'
input_file='/home/sakshi/SparkData/IntelliJData'
input='/home/sakshi/SparkData/Checking.txt'
output_file='/home/sakshi/SparkData/HugeDataSet.csv'
output='/home/sakshi/SparkData/FilteredData.txt'
#while inotifywait -q -e modify $input_file >/dev/null; do
#echo `date`
rm -f $testing
while read line; do var1=`echo "$line"` 
  while read line; do var2=`echo "$line"`
var1=`echo $var1 | sed -e 's/[^a-zA-Z ]/ /g; s/ '$var2' / /g'`
done <$Stop
echo $var1>>$testing
done <$output
#echo `date`
#done
