package com.serverless.function;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.serverless.dynamo.DynamoDBAccess;
import com.serverless.model.Request;
import com.serverless.model.Response;
import com.serverless.model.TestObject;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.function.Function;

public class LambdaFunction implements Function<Request, Response> {

    @Override
    public Response apply(Request request) {

        TestObject testObject = new TestObject();
        testObject.setCompleteName(String.format("%s_%s", request.getName(), request.getLastname()));
        testObject.setAge(request.getAge());

        DynamoDBMapper mapper = getMapper();

        mapper.save(testObject);

        Response response = new Response();
        response.setDateOfCreation(Long.toString(System.currentTimeMillis()));
        response.setObject(testObject);
        return response;

    }

    public DynamoDBMapper getMapper(){
        return new DynamoDBAccess().getDynamoDBMapper();
    }
}
