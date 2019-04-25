package com.demet.azurecosmosdb;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.tinkerpop.gremlin.driver.Client;
import org.apache.tinkerpop.gremlin.driver.Cluster;

@Component
public class GraphService {
	
	private Cluster cluster;
    private Client client;

	public Client connectGraph(String filePath) {
        try {
            // Attempt to create the connection objects
            cluster = Cluster.build(new File(filePath)).create();
            /* If we want to connect user pwd from params
             * .credentials(EnvironmentConstants.getCosmosDBUsername(), EnvironmentConstants.getCosmosDBPassword());
             * */
            client = cluster.connect();
        } catch (FileNotFoundException e) {
            // Handle file errors.
            System.out.println("Couldn't find the configuration file.");
            e.printStackTrace();
        }
        
        return client;
	}
	
}
