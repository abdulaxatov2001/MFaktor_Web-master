package com.example.botservice.feignClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "CatalogService")
public interface CatalogFeignClient {

}
