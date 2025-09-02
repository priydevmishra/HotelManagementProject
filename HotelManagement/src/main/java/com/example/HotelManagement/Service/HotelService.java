package com.example.HotelManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HotelManagement.DTO.RequestDTO.HotelAddressDTO;
import com.example.HotelManagement.Entity.Hotel;
import com.example.HotelManagement.Repository.HotelRepository;

@Service
public class HotelService {
    
    @Autowired
    private HotelRepository hotelRepository;

    public void saveHotel(Hotel hotel){
        hotelRepository.save(hotel);
    }

    public void updateHotel(Long id, HotelAddressDTO newHotelAddressDTO){
        Hotel oldHotel = hotelRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + id));
            oldHotel.setAddress(newHotelAddressDTO.getAddress());
            oldHotel.setAvailable(newHotelAddressDTO.isAvailable());
            oldHotel.setCity(newHotelAddressDTO.getCity());
            oldHotel.setPinCode(newHotelAddressDTO.getPinCode());
            oldHotel.setRating(newHotelAddressDTO.getRating());
            hotelRepository.save(oldHotel);
    }

    public void deleteHotel(Long id){
        hotelRepository.findById(id).orElseThrow(()-> new RuntimeException("Hotel not found with id: "+ id));
        hotelRepository.deleteById(id);
    }

    public Hotel getHotelById(Long id){
        Hotel hotel =  hotelRepository.findById(id).orElse(null);
        return hotel;
    }
}