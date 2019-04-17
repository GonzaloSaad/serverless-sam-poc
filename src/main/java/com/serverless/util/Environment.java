package com.serverless.util;

import java.util.Optional;

public class Environment {
    public static String getRegion() {
        Optional<String> awsRegion = Optional.ofNullable(System.getenv("AWS_REGION"));
        return awsRegion.orElseThrow(IllegalStateException::new);
    }

    public static String getStage() {
        Optional<String> environment = Optional.ofNullable(System.getenv("STAGE"));
        return environment.orElseThrow(IllegalStateException::new);
    }

    public static String getDynamoEndpoint(){
        Optional<String> dynamoUrl = Optional.ofNullable(System.getenv("DYNAMO_URL"));
        return dynamoUrl.orElseThrow(IllegalStateException::new);
    }

    public static boolean isLocalEnvironment(){
        return getStage().equals("local");
    }
}
