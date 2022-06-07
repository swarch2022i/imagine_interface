package com.imagine.imagine_interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imagine.imagine_interface.ClientSOAP.*;
import com.example.consumingwebservice.wsdl.*;
@RestController
@RequestMapping("/")
public class SoapClientController {
    @Autowired
    private SoapClient soapClient;
@GetMapping
public Country sum(@RequestParam String countr) {
GetCountryResponse response = soapClient.getCountry("http://localhost:8080/ws/countries",countr);
return response.getCountry();
}
}
