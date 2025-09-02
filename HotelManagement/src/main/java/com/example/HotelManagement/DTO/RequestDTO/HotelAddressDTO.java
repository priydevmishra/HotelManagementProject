package com.example.HotelManagement.DTO.RequestDTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class HotelAddressDTO {

    @DecimalMin(value="0.0", message="Rating Should be Greater than 0")
    @DecimalMax(value="5.0", message="Rating Should be Less than 5")
    private float rating;

    @NotBlank
    @Size(min=2, max=25, message="City must be between 2 to 25 Characters")
    private String city;

    @NotBlank(message="Address should not be Blank")
    @Size(min=4, max=100, message="Address must be between 4 to 100 Characters")
    private String address;

    @NotNull
    @Positive(message="pincode must be positive")
    private int pinCode;

    @Column(name="available")
    private boolean isAvailable;
}