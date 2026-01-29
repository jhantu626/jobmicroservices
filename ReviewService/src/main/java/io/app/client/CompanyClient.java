package io.app.client;

import io.app.dto.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CompanyService")
public interface CompanyClient {
    @GetMapping("/company/check/{id}")
    public ApiResponse companyExist(@PathVariable("id") long id);
}
