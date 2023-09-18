package com.example.accommodation.client.api;

import com.example.accommodation.client.request.OwnerUpdateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("OWNER-SERVICE")
public interface OwnerClient {
    @PatchMapping("/api/v1/owner/me")
    ResponseEntity<Void> updateOwner(@RequestBody OwnerUpdateRequest request);

}