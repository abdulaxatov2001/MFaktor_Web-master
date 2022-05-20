package com.example.adminservice.feignClient;

import com.example.adminservice.payload.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "CATALOG")
public interface CatalogFeignClient {

//
//    @GetMapping("/adsSource")
//    ApiResponse getAll();

}
