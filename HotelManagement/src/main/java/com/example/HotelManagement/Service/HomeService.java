package com.example.HotelManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HotelManagement.DTO.ResponseDTO.HomePageInfoDTO;
import com.example.HotelManagement.Entity.Hotel;
import com.example.HotelManagement.Repository.HotelRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<HomePageInfoDTO> getList(){
       List<HomePageInfoDTO> dtos = new ArrayList<>();
       List<Hotel> hotels = hotelRepository.findAll();
       for(Hotel hotel : hotels){
        HomePageInfoDTO dto = new HomePageInfoDTO(
            hotel.getId(),
            hotel.getHotelName(),
            hotel.getHotelSpeciality(),
            hotel.getPhoto()
        );
        dtos.add(dto);
       }
       return dtos;
    }
}