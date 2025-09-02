package com.example.HotelManagement.DTO.ResponseDTO;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class HomePageInfoDTO {

    private Long id;

    @NotBlank
    @Size(min=2, max=50, message="Hotel Name Must be Between 2 to 50 characters")
    private String hotelName;

    @NotBlank
    @Size(min=5, max=60, message="Speciality should be between 5 to 6 characters")
    private String hotelSpeciality;

    @Lob
    private byte[] photo;

    public HomePageInfoDTO(Long id, String hotelName, String hotelSpeciality, byte[] photo) {
    this.id = id;
    this.hotelName = hotelName;
    this.hotelSpeciality = hotelSpeciality;
    this.photo = photo;
}
}
