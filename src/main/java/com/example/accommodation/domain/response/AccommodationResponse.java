package com.example.accommodation.domain.response;
import com.example.accommodation.domain.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationResponse {
    private Long id;
    private UUID ownerId;
    private String sectors;
    private String ownerPhoneNum;
    private String address;
    private String sido;
    private String addressDetail;
    private String homepage;
    private String img;
    private String imgName;
    private String accoName;
    private String accoPhoneNum;
    private Status status;
    //여기서 DTO 같은건 나중에 생각
}
