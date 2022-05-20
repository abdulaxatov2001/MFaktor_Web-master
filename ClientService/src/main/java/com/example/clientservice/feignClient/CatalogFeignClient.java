package com.example.clientservice.feignClient;

import com.example.clientservice.entity.AdsSource;
import com.example.clientservice.entity.PaymentType;
import com.example.clientservice.payload.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CATALOG",url = "localhost:8080/api/catalog/")
//@FeignClient(name = "CATALOG")
public interface CatalogFeignClient {

//    @GetMapping("/adsSource")
//    ApiResponse getAll();

    @GetMapping("adsSource/{id}")
    ApiResponse<AdsSource> getAdsSource(@PathVariable Integer id);

    @GetMapping("paymentType/{id}")
    ApiResponse<PaymentType> getPaymentType(@PathVariable Integer id);

}
