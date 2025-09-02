package com.example.HotelManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HotelManagement.DTO.ResponseDTO.AllHotelsDTO;
import com.example.HotelManagement.Service.AllHotelsService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class AllHotelsController {
    
    @Autowired
    private AllHotelsService allHotelsService;

    @GetMapping("/allHotels")
    public List<AllHotelsDTO> allHotels(Model model){

        List<AllHotelsDTO> listOfHotels = allHotelsService.getHotelList();
        // model.addAttribute("listOfHotels", listOfHotels);
        // return "AllHotels";
        return listOfHotels;
    }
}