package com.serverless.util;


import org.apache.commons.codec.binary.StringUtils;

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

    public static boolean isLocalEnvironment(){
        return getStage().equals("local");
    }

    public static String getDynamoEndpoint(){
        Optional<String> dynamoUrl = Optional.ofNullable(System.getenv("DYNAMO_URL"));
        return dynamoUrl.orElseThrow(IllegalStateException::new);
    }

    public static String getAccessKeyId(){
        Optional<String> accessKeyId = Optional.ofNullable(System.getenv("AWS_ACCESS_KEY_ID"));
        return accessKeyId.orElseThrow(IllegalStateException::new);
    }

    public static String getsecretAccessKey(){
        Optional<String> secretAccessKey = Optional.ofNullable(System.getenv("AWS_SECRET_ACCESS_KEY"));
        return secretAccessKey.orElseThrow(IllegalStateException::new);
    }


}
