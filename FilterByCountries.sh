#!/bin/sh
output_file='/home/sakshi/SparkData/HugeDataSet.csv'
	rm -rf USA.csv
	rm -rf India.csv
	rm -rf England.csv
	
	grep -Fwf ExtractUS.csv $output_file >> USA.csv
	grep -Fwf ExtractIndia.csv $output_file >> India.csv
	grep -Fwf ExtractEngland.csv $output_file>> England.csv
	grep -Fwf 'null' $output_file>>null.csv
	#paste ExtractUS.csv $output_file | awk '$1=$1' >>USA.csv
	#paste ExtractIndia.csv $output_file | awk '$1=$1' >>India.csv
