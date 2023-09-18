package com.example.accommodation.repository;

import com.example.accommodation.domain.entity.Accommodation;
import com.example.accommodation.domain.response.AccoResponseForAll;
import com.example.accommodation.domain.response.AccommodationResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccoRepository extends JpaRepository<Accommodation,Long> {


    @Query("select new com.example.accommodation.domain.response.AccoResponseForAll(a.id, a.ownerId,a.sectors,a.accoName,a.status) from Accommodation a")
   List<AccoResponseForAll> findAllByCondition();
}
