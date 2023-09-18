package com.example.accommodation.domain.response;

import com.example.accommodation.domain.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccoResponseForAll {
    private Long id;
    private UUID ownerId;
    private String sectors;
    private String accoName;
    private Status status;
}
