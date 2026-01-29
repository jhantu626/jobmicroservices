package io.app.client;

import io.app.dto.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "JobService")
public interface JobClient {
    @GetMapping("/job/check/{id}")
    public ApiResponse checkJobExist(@PathVariable("id") long id);
}
