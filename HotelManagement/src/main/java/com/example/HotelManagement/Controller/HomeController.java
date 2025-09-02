package com.example.HotelManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HotelManagement.DTO.ResponseDTO.HomePageInfoDTO;
import com.example.HotelManagement.Service.HomeService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("/")
    public List<HomePageInfoDTO> getHotelList(Model model){
        List<HomePageInfoDTO> hotels = homeService.getList();
        // model.addAttribute("hotels", hotels);
        return hotels;
    }
}
