package com.imagine.imagine_interface.SOAP;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class ProfileEndpoint {
	private static final String NAMESPACE_URI = "http://imagine.com/imagine-interface";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProfileRequest")
	@ResponsePayload
	public GetProfileResponse getProfile() {
		GetProfileResponse response = new GetProfileResponse();
		response.getName().add("probando");
        response.getName().add("ando");
        response.getName().add("24");

		return response;
	}

    
}