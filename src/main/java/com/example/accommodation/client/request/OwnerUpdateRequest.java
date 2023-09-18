package com.example.accommodation.client.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OwnerUpdateRequest {

    private String email;
    private String status;
}
