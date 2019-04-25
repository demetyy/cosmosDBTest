package com.demet.azurecosmosdb;

public class Constants {
	public static String getGraphYamlPath() {
        String GraphYmlPath = System.getenv("GRAPH_YAML_PATH");
        if (GraphYmlPath == null)
            GraphYmlPath = "remote.yaml";
        return GraphYmlPath;
    }
	public static String getGraphTestYamlPath() {
        String GraphYmlPath = System.getenv("GRAPH_TEST_YAML_PATH");
        if (GraphYmlPath == null)
            GraphYmlPath = "remote-test.yaml";
        return GraphYmlPath;
    }
	public static String getCosmosDBUsername() {
        String CosmosDBUsername = System.getenv("USER_NAME");
        if (CosmosDBUsername == null)
        	CosmosDBUsername = "user";
        return CosmosDBUsername;
    }
	public static String getCosmosDBPassword() {
        String CosmosDBPassword = System.getenv("PASSWORD");
        if (CosmosDBPassword == null)
        	CosmosDBPassword = "password";
        return CosmosDBPassword;
    }
}
