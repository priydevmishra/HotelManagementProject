package com.example.HotelManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HotelManagement.Repository.HotelRepository;

@Service
public class HotelAddressService {
    
    @Autowired
    HotelRepository hotelRepository;

    // public void updateHotel(Long id, HotelAddressDTO newHotelAddressDTO){
    //     Optional<Hotel> hotelBox = hotelRepository.findById(id).orElse(null);
    //                                 // .orElseThrow(() -> new RuntimeException("Hotel Id was not found with id : " +id));
    //     if(hotelBox!=null){
    //         Hotel oldHotel = hotel.get();

    //     }

        
    // }
}