import React from 'react'

const HotelInfoCardHome = ({ src, hotelName, speciality }) => {
  return (
    <div className="shadow-lg rounded-xl m-5 w-[300px] overflow-hidden bg-white hover:shadow-2xl transition duration-300">
      <div className="overflow-hidden">
        <img
          className="w-full h-[150px] object-cover transform hover:scale-110 transition-transform duration-500"
          src={src}
          alt={hotelName}
        />
      </div>

      <div className="p-3">
        <h2 className="text-xl font-bold text-gray-800">{hotelName}</h2>
        <p className="text-sm text-gray-600 mt-1">{speciality}</p>

        {/* Rating + Price Section */}
        <div className="flex justify-between items-center mt-2">
          <span className="text-yellow-500 font-semibold text-sm">{}</span>
          <span className="text-green-600 font-bold text-sm">₹{} / night</span>
        </div>

        {/* Action Buttons */}
        <div className="flex gap-2 mt-4">
          <button className="flex-1 bg-gray-700 text-white py-2 rounded-md font-medium hover:bg-black cursor-pointer transition">
            See Hotel
          </button>
          <button className="flex-1 bg-[#F3F4F6] text-black py-2 rounded-md font-medium hover:bg-gray-200 cursor-pointer transition">
            Book Now
          </button>
        </div>
      </div>
    </div>
  )
}

export default HotelInfoCardHome
