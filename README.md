# DataAnalysis
The aim is to apply network text analysis on extracted tweets region-wise for a product based company to analyse the sentiments of the customers in a given region.
Procedure:
The tweets are extracted in real-time based on a keyword (the company name) and saved in a file. 
A daemon in shell script is run to check if there are any changes in the file containing the tweets. (Eventhough a java program can be run to do the same, I wanted to experiment with shell scripts). This shell script then filters and tokenizes the text. It also removes the stop words.
Once the data is cleaned, we can use frequency tables, word graphs etc to visualize the data and analyse the reactions and thoughts of customers on a certain product of the company.
