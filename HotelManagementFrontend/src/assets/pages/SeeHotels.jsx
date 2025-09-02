import React from "react";
import { useEffect, useState } from "react";
import Header from "../components/Header";
import Search from "../components/Search";
import HotelInfoCard from "../components/HotelInfoCard";

function SeeHotels(){

    const[hotels, SetHotels] = useState([]);
    useEffect(()=>{
        fetch("http://localhost:8080/allHotels")
        .then((res) => res.json())
        .then((data)=>SetHotels(data))
        .catch((err) => console.error("Error in Fetching Data", err))
    },[]);
    const name = "Priydev Mishra";
    console.log(hotels)
return(
    <>
<Header text={`Hii ${name}... Welcome to Hotel`} />
<Search className="items-center justify-center text-center" />
<div className="flex flex-wrap justify-around">
{ hotels.map((hotel) =>(
        <HotelInfoCard
        key={hotel.id}
        src = {`http://localhost:8080/hotel/photo/${hotel.id}`}
        hotelName = {hotel.hotelName}
        speciality ={hotel.speciality}
        rating = {hotel.rating}
        city = {hotel.city}
        />
    ))
}
    </div>
    </>

);
}
export default SeeHotels;