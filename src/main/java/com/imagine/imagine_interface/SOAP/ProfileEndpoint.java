package com.imagine.imagine_interface.SOAP;

import org.springframework.web.client.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.graphql.client.WebGraphQlClient;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.fasterxml.jackson.databind.ObjectMapper;

import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;


@Endpoint
public class ProfileEndpoint {
    private static final String NAMESPACE_URI = "http://imagine.com/imagine-interface";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProfileRequest")
    @ResponsePayload
    public GetProfileResponse getProfile() {
        GetProfileResponse response = new GetProfileResponse();
        //COSAS DE GRAPHQL-----------------------------------------------------
        WebClient webClient = WebClient.builder()
                .baseUrl("http://34.69.21.16:5000/graphql")// url of graphql instance
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        GraphQLWebClient graphQLWebClient = GraphQLWebClient.newInstance(webClient, objectMapper);
        GraphQLRequest request = GraphQLRequest.builder().query("query{allPerfiles{nombre}}").build();
        GraphQLResponse responseGRAPH = graphQLWebClient.post(request).block();
        ArrayList<Object> prueba = new ArrayList<Object>();
        prueba = (ArrayList<Object>) responseGRAPH.get("allPerfiles", Object.class);
        System.out.println(prueba.get(0).getClass());

        System.out.println(prueba);

        
        //COSAS DE GRAPHQL-----------------------------------------------------
        
          response.getName().add("probando");
          response.getName().add("ando");
          response.getName().add("24");
         

        return response;
    }

}