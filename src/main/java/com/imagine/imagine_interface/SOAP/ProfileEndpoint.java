package com.imagine.imagine_interface.SOAP;


import org.springframework.web.reactive.function.client.WebClient;


import java.util.ArrayList;
import java.util.LinkedHashMap;


import org.springframework.beans.factory.annotation.Value;

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

    @Value("${graphql.client.url}")
    private String graphqlClientUrl;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProfileRequest")
    @ResponsePayload
    public GetProfileResponse getProfile() {
        
        GetProfileResponse response = new GetProfileResponse();
        //COSAS DE GRAPHQL-----------------------------------------------------
        WebClient webClient = WebClient.builder()
                .baseUrl(graphqlClientUrl)// url of graphql instance
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        GraphQLWebClient graphQLWebClient = GraphQLWebClient.newInstance(webClient, objectMapper);
        GraphQLRequest request = GraphQLRequest.builder().query("query{allPerfiles{nombre}}").build();
        GraphQLResponse responseGRAPH = graphQLWebClient.post(request).block();
        ArrayList<LinkedHashMap> prueba = new ArrayList<LinkedHashMap>();
        prueba = (ArrayList<LinkedHashMap>) responseGRAPH.get("allPerfiles", Object.class);

        //COSAS DE GRAPHQL-----------------------------------------------------
        for(int i = 0; i < prueba.size();i ++){
            response.getName().add((String) prueba.get(i).get("nombre"));
        }
          
         

        return response;
    }

}