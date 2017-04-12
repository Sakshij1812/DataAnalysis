/*
  Created by sakshi on 5/3/17.
 */

import com.google.common.collect.Lists;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Tweets {
    public static void main(String args[]) throws InterruptedException {


        // Create a local StreamingContext with two working thread and batch interval of 1 second
        /*SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("DataAnalysis");
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(1));

        // Create a DStream that will connect to hostname:port, like localhost:9999
        JavaReceiverInputDStream<String> lines = jssc.socketTextStream("localhost", 9999); */

        //org.apache.log4j.BasicConfigurator.configure();




        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10000);
        StatusesFilterEndpoint endpoint = new StatusesFilterEndpoint();
        endpoint.trackTerms(Lists.newArrayList("Microsoft"));

        Authentication auth = new OAuth1("ZwnPwg3PwvBJmvFYKeJncZYfv", "DMauWQhDF5CcLJJ4Q3H4Tm2D8WeoWxess6MZVORpUYMfMJfSGH", "826441997661515776-Iwmj9b9QWuzlIibKaBwJ0y7wX7oX3wL", "Hyrf0xQyfW6iby6ywol4AFNUg4zLuD6pKNI6h2e3JJ6QI");

        Client client = new ClientBuilder()
                .hosts(Constants.STREAM_HOST)
                .endpoint(endpoint)
                .authentication(auth)
                .processor(new StringDelimitedProcessor(queue))
                .build();

        client.connect();

        for (int msgRead = 0; msgRead < 1000; msgRead++)
        {
            //Called once a new tweet is detected
            final String msg = queue.take();


           System.out.println(msg);


           /* JavaDStream<String> filteredMsg = lines.filter(new Function<String, Boolean>() {
                public Boolean call(String line) {
                    return line.contains("text");
                } */

            //get("/bye", (req, res) -> (msg+"\n"));
        }
            client.stop();

           /* jssc.start();
            jssc.awaitTermination(); */
        }

}