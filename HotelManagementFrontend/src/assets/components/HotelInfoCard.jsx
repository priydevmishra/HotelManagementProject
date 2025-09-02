import React from 'react'

const HotelInfoCard = ({ src, hotelName, rating, city, speciality}) => {
  return (
    <div className=' shadow rounded-xl m-5 w-[300px] overflow-hidden'>
      <img className="w-full h-[150px] object-cover " src={src} alt="No Image" />
      <div className='p-3'>
        <h2 className='text-xl font-bold'>{hotelName}</h2>
        <p className='text-[14px]'>{speciality}</p>
        <p className='text-[14px]'>{rating}</p>
        <p className='text-[14px]' >{city}</p>
      </div>
    </div>
  )
}

export default HotelInfoCard;
