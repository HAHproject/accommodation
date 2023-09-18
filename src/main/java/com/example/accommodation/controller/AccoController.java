package com.example.accommodation.controller;

import com.example.accommodation.Service.AccoService;
import com.example.accommodation.config.JwtService;
import com.example.accommodation.config.TokenInfo;
import com.example.accommodation.domain.entity.Accommodation;
import com.example.accommodation.domain.request.AccommodationRequest;
import com.example.accommodation.domain.response.AccoResponseForAll;
import com.example.accommodation.domain.response.AccommodationResponse;
import jakarta.ws.rs.PATCH;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/acco")
@RequiredArgsConstructor
public class AccoController {

    private final JwtService jwtService;
    private final AccoService accoService;


    @PostMapping("/apply")
    public void apply(
            @RequestBody AccommodationRequest accommodationRequest
           // ,@RequestHeader("Authorization") String token
                      ) throws IOException {

       // TokenInfo tokenInfo = jwtService.parseToken(token.replace("Bearer ", ""));

        // 토큰 근데 써야하나? 어짜피 바디에 있는데?.. 고민


        accoService.apply(accommodationRequest);

    }

    @GetMapping("/apply/all")
    public List<AccoResponseForAll> getAll(){
        // 이건 어드민이 접근할 수 있어야한다...
       return accoService.getAll();
    }




    @PatchMapping("/apply/{id}")
    public void sign(@PathVariable Long id){

        accoService.sign(id);

    }
}
