import React from "react";
import SeeHotels from "./assets/pages/SeeHotels";
import {BrowserRouter as Router, Routes, Link, Route  } from "react-router-dom";
import HotelDetails from "./assets/pages/HotelDetails";
import HomePage from "./assets/pages/HomePage";

function App(){
return(
   <Router>
    <nav className="flex justify-end bg-black gap-4 cursor-pointer p-4 items-center sticky top-0 z-[1000] [scrollbar-gutter: stable]">
      <Link className="relative text-white font-medium 
after:content-[''] after:absolute after:left-1/2 after:bottom-0 
after:w-0 after:h-[2px] after:bg-green-500 
after:transition-all after:duration-300 after:-translate-x-1/2 
hover:after:w-full" to="/">Home</Link>  

      <Link className="relative text-white font-medium 
after:content-[''] after:absolute after:left-1/2 after:bottom-0 
after:w-0 after:h-[2px] after:bg-green-500 
after:transition-all after:duration-300 after:-translate-x-1/2 
hover:after:w-full" to="/seeHotels">See Hotels</Link>  

      <Link className="relative text-white font-medium 
after:content-[''] after:absolute after:left-1/2 after:bottom-0 
after:w-0 after:h-[2px] after:bg-green-500 
after:transition-all after:duration-300 after:-translate-x-1/2 
hover:after:w-full" to="/hotel/createHotel">Create Hotel</Link>  
      
      {/* <Link to="/contact">Contact</Link>   */}
    </nav>

    <Routes>
        <Route path="/" element={<HomePage/>} />
        <Route path="/seeHotels" element={<SeeHotels/>} />
        <Route path="/hotel/createHotel" element={<HotelDetails/>} />
        {/* <Route path="/contact" /> */}
    </Routes>
   </Router>
);
}
export default App;