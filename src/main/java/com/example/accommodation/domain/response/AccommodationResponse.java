package com.example.accommodation.domain.response;
import com.example.accommodation.domain.entity.Accommodation;
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
    private String ownerId;
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
    private String status;
    //여기서 DTO 같은건 나중에 생각

    public AccommodationResponse(Accommodation accommodation){
        this.id = accommodation.getId();
        this.ownerId = "1";
        this.sectors = accommodation.getSectors();
        this.ownerPhoneNum = accommodation.getOwnerPhoneNum();
        this.address = accommodation.getAddress();
        this.sido = accommodation.getSido();
        this.addressDetail = accommodation.getAddressDetail();
        this.homepage = accommodation.getHomePage();
        this.img = accommodation.getImg();
        this.imgName = accommodation.getImgName();
        this.accoName = accommodation.getAccoName();
        this.accoPhoneNum = accommodation.getAccoPhoneNum();
        this.status = accommodation.getStatus().name();
    }
}
