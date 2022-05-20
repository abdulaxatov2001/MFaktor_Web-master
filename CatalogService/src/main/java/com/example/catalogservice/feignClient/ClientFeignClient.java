package com.example.catalogservice.feignClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "CLIENT")
public interface ClientFeignClient {

}
