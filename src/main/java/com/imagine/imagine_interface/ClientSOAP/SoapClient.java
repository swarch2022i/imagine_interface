package com.imagine.imagine_interface.ClientSOAP;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.consumingwebservice.wsdl.*;
public class SoapClient extends WebServiceGatewaySupport {
    public GetCountryResponse getCountry(String url,String country){
        GetCountryRequest request  = new GetCountryRequest();
        request.setName(country);
        GetCountryResponse res = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(url,request,
        new SoapActionCallback(
            "http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));
        return  res;
    }
}
