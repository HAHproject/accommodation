package com.example.accommodation.Service;


import com.example.accommodation.client.api.OwnerClient;
import com.example.accommodation.client.request.OwnerUpdateRequest;
import com.example.accommodation.domain.entity.Accommodation;
import com.example.accommodation.domain.entity.Status;
import com.example.accommodation.domain.request.AccommodationRequest;
import com.example.accommodation.domain.response.AccoResponseForAll;
import com.example.accommodation.domain.response.AccommodationResponse;
import com.example.accommodation.repository.AccoRepository;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.*;
import com.google.firebase.cloud.StorageClient;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Base64InputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccoService {

    private final AccoRepository accoRepository;

    private final OwnerClient ownerClient;

    @Value("${app.firebase-bucket}")
    private String firebaseBucket;

    @Value("${app.firebase-configuration-file}")
    private String firebaseConfigPath;



    public void apply(AccommodationRequest accommodationRequest) throws IOException {


        Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);

       String data = accommodationRequest.getImg().split(",")[1];

        byte[] bytes = Base64.decodeBase64(data);

        InputStream content = new ByteArrayInputStream(bytes);

        Blob blob = bucket.create("images/" + accommodationRequest.getImgName(), content,accommodationRequest.getImgType());
        // Blob 객체의 공개 URL 생성
        String publicUrl = blob.getMediaLink();




        accommodationRequest.toEntity(publicUrl);

        accoRepository.save(accommodationRequest.toEntity(publicUrl));
        ownerClient.updateOwner(new OwnerUpdateRequest(accommodationRequest.getOwnerEmail(), "APPLYING"));

        // 여기서 owner도 바뀌어야함.

    }
    
    public List<AccoResponseForAll> getAll(){
        return accoRepository.findAllByCondition();
    }

    @Transactional
    public void sign(Long id){

        Optional<Accommodation> byId = accoRepository.findById(id);

        Accommodation store = byId.orElseThrow(() -> new RuntimeException("그런 아이디 없음"));
        store.setStatus(Status.승인);
    }
    
    
    public AccommodationResponse getById(Long id){

        Accommodation accommodation = accoRepository.findById(id).orElseThrow(() -> new RuntimeException("그런거 없어"));


        return new AccommodationResponse(accommodation);


    }

    public AccommodationResponse getByOwnerId(String uid){

        try {


            Accommodation ownerId = accoRepository.findByOwnerId(UUID.fromString(uid));
            return new AccommodationResponse(ownerId);
        }catch (Exception e){
            return null;
        }

    }


    public List<Accommodation> getAllByCondition(){
       return accoRepository.findAllByConditionForUser();
    }
}
