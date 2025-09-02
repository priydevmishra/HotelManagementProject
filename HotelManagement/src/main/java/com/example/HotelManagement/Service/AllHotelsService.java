package com.example.HotelManagement.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HotelManagement.DTO.ResponseDTO.AllHotelsDTO;
import com.example.HotelManagement.Entity.Hotel;
import com.example.HotelManagement.Repository.HotelRepository;

@Service
public class AllHotelsService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<AllHotelsDTO> getHotelList(){
    List<AllHotelsDTO> dtos = new ArrayList<>();
    List<Hotel> hotels = hotelRepository.findAll();
    
    for(Hotel hotel : hotels){
        AllHotelsDTO dto = new AllHotelsDTO(
            hotel.getId(),
            hotel.getHotelName(),
            hotel.getHotelSpeciality(),
            hotel.getRating(),
            hotel.getCity()
            // hotel.getState(),
            // hotel.getType()
        );
        dtos.add(dto);
    }
    return dtos;
}

}