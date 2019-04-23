package com.demet.azurecosmosdb;

import org.apache.tinkerpop.gremlin.driver.Client;
import org.apache.tinkerpop.gremlin.driver.Result;
import org.apache.tinkerpop.gremlin.driver.ResultSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GraphDbIntegrationTests {
	
	@Autowired
	private GraphService graphService;
	
	@Before
	public void setUp() {
		graphService.connectGraph().submit("g.V().drop()").all().join();
	}
	
	@Test
	private void simpleGraphTest_success() throws Exception {
		Client client = graphService.connectGraph();
		
		String gremlinQuery = "";
		
		// After connection is successful, run the query against the server.
        System.out.println("\nSubmitting this Gremlin query: " + gremlinQuery);

        // Submitting remote query to the server.
        ResultSet results = client.submit(gremlinQuery);
        
        CompletableFuture<List<Result>> completableFutureResults;
        List<Result> resultList = null;

        try{
            completableFutureResults = results.all();
            resultList = completableFutureResults.get();
        }
        catch(ExecutionException | InterruptedException e){
            e.printStackTrace();
            throw(e);
        }
        catch(Exception e){
            e.printStackTrace();
            throw(e);
        }

        for (Result result : resultList) {
            System.out.println("\nQuery result:");
            System.out.println(result.toString());
            Assert.assertEquals("", result.toString());
        }
       
	}
}
