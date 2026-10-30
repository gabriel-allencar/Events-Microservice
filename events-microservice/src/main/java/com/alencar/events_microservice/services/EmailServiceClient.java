package com.alencar.events_microservice.services;

import com.alencar.events_microservice.dtos.EmailRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name ="email-service-aws", url = "${email-service.url:http://localhost:8081}")
public interface EmailServiceClient {
    @PostMapping("/api/email/send")
    void sendEmail(@RequestBody EmailRequestDTO emailRequest);
}



//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@FeignClient(name = "email-service", url = "http://endereco-do-servico-de-email")
//public interface EmailServiceClient {
//
//    @PostMapping("/send")
//    void sendEmail(@RequestBody EmailRequestDTO emailRequest);
//}
