package com.example.accommodation.domain.request;

import com.example.accommodation.domain.entity.Accommodation;
import com.example.accommodation.domain.entity.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationRequest {

    private String ownerEmail;
    private UUID ownerId;
    private String ownerName;
    private String sectors;
    private String ownerPhoneNum;
    private String address;
    private String sido;
    private String addressDetail;
    private String homePage;
    private String img;
    private String imgName;
    private String imgType;
    private String accoName;
    private String accoPhoneNum;

    private Status status;


    public Accommodation toEntity(String url){
       return Accommodation
                .builder()
                .ownerId(ownerId)
                .ownerPhoneNum(ownerPhoneNum)
                .sectors(sectors)
                .address(address)
                .addressDetail(addressDetail)
                .sido(sido)
                .homePage(homePage)
                .img(url)
                .imgName(imgName)
                .accoName(accoName)
                .accoPhoneNum(accoPhoneNum)
                .status(status)
                .build();
    }
}
