package com.example.HotelManagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name="hotel_info")
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    // @NotBlank
    // @Size(min=2, max=50, message="Hotel Name Must be Between 2 to 50 Characters")
    private String hotelName;

    // @NotEmpty
    // @Pattern(regexp="^[0-9]{10}$", message="Mobile Number Must be of 10 Digits")
    private String mobileNumber;

    // @NotEmpty
    // @Pattern(regexp="^[A-Za-z0-9.+_-]+@[A-Za-z]+\\.[A-Za-z]{2,6}$", message="Please Enter Your Correct Email")
    private String email;

    // @DecimalMin(value="0.0", message="Rating Should be Greater than 0")
    // @DecimalMax(value="5.0", message="Rating Should be Less than 5")
    private float rating;

    // @NonNull
    // @Positive(message="Available Rooms Must be Positive")
    private int totalRooms;

    // @NonNull
    // @Positive(message="Available Rooms Must be Positive")
    private int availableRooms;

    // @NonNull
    // @Positive(message="Available Rooms Must be Positive")
    private int bookedRooms;

    // @NotBlank
    // @Size(min=2, max=25, message="City must be between 2 to 25 Characters")
    private String city;

    // @NotBlank(message="Address should not be Blank")
    // @Size(min=4, max=100, message="Address must be between 4 to 100 Characters")
    private String address;

    // @NotNull
    // @Positive(message="pincode must be positive")
    private int pinCode;
    
    private String password;

    // @NotBlank
    // @Size(min=5, max=60, message="Speciality should be between 5 to 6 characters")
    private String hotelSpeciality;

    @NotBlank
    private String state = "UttarPradesh";

    @NotBlank
    private String type = "Available";

    @Lob
    @Column(name = "photo", columnDefinition = "LONGBLOB")
    private byte[] photo;
 
    @Column(name="available")
    private boolean isAvailable;
}