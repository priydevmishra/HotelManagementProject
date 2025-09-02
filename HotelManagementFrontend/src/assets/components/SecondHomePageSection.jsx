import React from 'react'
import HotelInfoCardHome from './HotelInfoCardHome'

const SecondHomePageSection = ({hotels}) => {
  return (
    <div className='mx-7 p-7 my-2'>
      <h1 className='font-bold text-3xl text-center mb-5'>Premium Hotels</h1>
      <div className='flex flex-wrap justify-around sm:justify-around'>
        {hotels.map((hotel)=>(
          <HotelInfoCardHome
          key={hotel.id}
          src={`http://localhost:8080/hotel/photo/${hotel.id}`}
          hotelName={hotel.hotelName}
          speciality={hotel.hotelSpeciality}
           />
        ))}
      </div>
    </div>
  )
}

export default SecondHomePageSection
