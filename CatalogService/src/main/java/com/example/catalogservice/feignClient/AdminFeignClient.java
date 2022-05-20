package com.example.catalogservice.feignClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ADMIN")
public interface AdminFeignClient {

}
