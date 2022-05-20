package com.example.botservice.feignClient;

import com.example.botservice.entity.AttachmentContent;
import com.example.botservice.payload.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AdminService")
public interface AdminFeignClient {
   @GetMapping("/attachment/getAttachment/{id}")
    ApiResponse getAttachmentById(@PathVariable Integer id);
}
