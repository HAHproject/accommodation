package com.example.accommodation.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Accommodation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID ownerId;
    private String sectors;
    private String ownerPhoneNum;
    private String address;
    private String sido;
    private String addressDetail;
    private String homePage;
    private String img;
    private String imgName;
    private String accoName;
    private String accoPhoneNum;

    @Enumerated(EnumType.STRING)
    private Status status;


}
