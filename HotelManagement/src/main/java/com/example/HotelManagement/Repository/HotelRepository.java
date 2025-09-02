package com.example.HotelManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HotelManagement.Entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{
    
}