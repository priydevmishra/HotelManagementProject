package com.example.HotelManagement.DTO.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AllHotelsDTO {
    
    private Long id;
    private String hotelName;
    private String speciality;
    private float rating;
    private String city;
    // private String state;
    // private String type;
    
}