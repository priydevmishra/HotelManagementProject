package com.example.HotelManagement.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.HotelManagement.DTO.RequestDTO.HotelAddressDTO;
import com.example.HotelManagement.Entity.Hotel;
import com.example.HotelManagement.Service.HotelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hotel")
@CrossOrigin(origins = "http://localhost:5173")
public class hotelController {

    @Autowired
    private HotelService hotelService;
    
    // @GetMapping("/createHotel")
    // public String hotelDetails() {
    //     // model.addAttribute("hotel", new Hotel());  no need of get req in because react makes pages automatically and renders
    //     // return "HotelDetails";
        
    // }

    @PostMapping("/createHotel")
    // @ResponseBody
    public ResponseEntity<?> createNewHotel(
        @RequestPart("hotel") @Valid Hotel hotel,
        BindingResult result,

        @RequestPart(value = "photo", required = false) MultipartFile file) throws IOException  {
        
        if (result.hasErrors()) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

    try {
        if (file != null && !file.isEmpty()) {
            hotel.setPhoto(file.getBytes());
        }
        hotelService.saveHotel(hotel);
        return ResponseEntity.ok("Hotel created successfully!");
    }
     catch (IOException e) {
        return ResponseEntity.status(500).body("Error saving hotel");
    }
    }

    @PutMapping("/updateDetails/{id}")
    public String updateExistingHotel(@PathVariable Long id, @RequestBody HotelAddressDTO hotelDTO) {
        hotelService.updateHotel(id, hotelDTO);
        return "Hotel Updated Successfully";
    }

    @DeleteMapping("/deleteHotel/{id}")
    public String deleteHotel(@PathVariable Long id){
        hotelService.deleteHotel(id);
        return "Hotel Deleted Successfully";
    } 

    @GetMapping("/photo/{id}")
    public ResponseEntity<byte[]> getHotelPhoto(@PathVariable Long id) {
        Hotel hotel = hotelService.getHotelById(id);
        if (hotel == null || hotel.getPhoto() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")  // ya image/png
                .body(hotel.getPhoto());
    }
}