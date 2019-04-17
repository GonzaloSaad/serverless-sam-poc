package com.serverless.dynamo;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.serverless.util.Environment;

public class DynamoDBAccess {

    public DynamoDBMapper getDynamoDBMapper(){
        return dynamoDBMapper();
    }

    private DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(getClient(), dynamoDBMapperConfig());
    }

    private AmazonDynamoDB getClient(){
        AmazonDynamoDB dynamoDBClient;
            if(Environment.isLocalEnvironment()){
                dynamoDBClient = getLocalClient();
            } else {
                dynamoDBClient = getCloudClient();
            }

        return dynamoDBClient;
    }

    private AmazonDynamoDB getCloudClient() {
        return AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.fromName(Environment.getRegion()))
                .build();
    }

    private AmazonDynamoDB getLocalClient() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(getEndpointConfiguration())
                .build();
    }

    private AwsClientBuilder.EndpointConfiguration getEndpointConfiguration() {
        return new AwsClientBuilder
                .EndpointConfiguration(Environment.getDynamoEndpoint(), Environment.getRegion());
    }

    public DynamoDBMapperConfig dynamoDBMapperConfig() {
        DynamoDBMapperConfig.Builder builder = DynamoDBMapperConfig.builder();
        builder.setTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNamePrefix(getFormattedPrefix()));
        return builder.build();
    }

    private String getFormattedPrefix(){
        return String.format("%s-", Environment.getStage());
    }
}
