import React from 'react'
import { useState } from 'react'

const HotelDetails = () => {
    const [hotel, setHotel] = useState({
        hotelName :'',
        mobileNumber :'',
        email :'',
        city :'',
        address :'',
        pinCode :'',
        rating :'',
        totalRooms :'',
        availableRooms :'',
        bookedRooms :'',
        photo : null,
        hotelSpeciality :''
})

const [errors, setErrors] = useState({});

const handleChange = (e)=>{
    setHotel({
        ...hotel, [e.target.name]: e.target.value
    })
}

const handleSubmit = async (e)=>{
    e.preventDefault();
    setErrors({});

try {
    const { photo, ...hotelData } = hotel;
    const formData = new FormData();
    formData.append("hotel", new Blob([JSON.stringify(hotelData)], { type: "application/json" }));
    if (photo) {
      formData.append("photoFile", hotel.photo);
    }

    const response = await fetch("http://localhost:8080/hotel/createHotel", {
      method: "POST",
      body: formData
    });

    if (!response.ok) {
      const errorData = await response.json();
      setErrors(errorData);
    } else {
      const data = await response.text();
      alert(data);
    }
  } catch (err) {
    console.error(err);
  }
};
  return (
    <div className='border-none shadow-xl m-4 p-4 rounded-2xl'>
        <div className='flex justify-center items-center '><h2 className='font-bold text-3xl mb-5 mt-2  ' >Add Hotel Information</h2></div>
      <form className='grid [grid-template-columns:repeat(auto-fit,minmax(280px,1fr))] gap-6 ' onSubmit={handleSubmit}>


        <div className="flex flex-col" >
        <label>Hotel Name</label>
        <input className="border-[1px] border-[#ccc] rounded p-1 m-2 w-[] outline-none transition-[border] duration-300 " type="text" name='hotelName' value={hotel.hotelName} onChange={handleChange} />
        {errors.hotelName && <p>{errors.hotelName}</p>}
        </div>

        <div className="flex flex-col" >
        <label>Mobile Number</label>
        <input className="border-[1px] border-[#ccc] rounded p-1 m-2 w-[] outline-none transition-[border] duration-300 " type="text" name='mobileNumber' value={hotel.mobileNumber} onChange={handleChange} />
        {errors.mobileNumber && <p>{errors.mobileNumber}</p>}
        </div>

        <div className="flex flex-col" >
        <label>Email</label>
        <input className="border-[1px] border-[#ccc] rounded p-1 m-2 w-[] outline-none transition-[border] duration-300 " type="text" name='email' value={hotel.email} onChange={handleChange} />
        {errors.email && <p>{errors.email}</p>}
        </div>

        <div className="flex flex-col" >
        <label>City</label>
        <input className="border-[1px] border-[#ccc] rounded p-1 m-2 w-[] outline-none transition-[border] duration-300 " type="text" name='city' value={hotel.city} onChange={handleChange} />
        {errors.city && <p className='text-red-600'>{errors.city}</p>}
        </div>

        <div className="flex flex-col" >
        <label>Address</label>
        <input className="border-[1px] border-[#ccc] rounded p-1 m-2 w-[] outline-none transition-[border] duration-300 " type="text" name='address' value={hotel.address} onChange={handleChange} />
        {errors.address && <p>{errors.address}</p>}
        </div>

        <div className="flex flex-col" >
        <label>PinCode</label>
        <input className="border-[1px] border-[#ccc] rounded p-1 m-2 w-[] " type="text" name='pinCode' value={hotel.pinCode} onChange={handleChange} />
        {errors.pinCode && <p>{errors.pinCode}</p>}
        </div>

        <div className="flex flex-col" >
        <label>Rating</label>
        <input className="border-[1px] border-[#ccc] rounded p-1 m-2 w-[] outline-none transition-[border] duration-300 " type="number" name='rating' value={hotel.rating} onChange={handleChange} />
        {errors.rating && <p>{errors.rating}</p>}
        </div>

        <div className="flex flex-col" >
        <label>Total Rooms</label>
        <input className="border-[1px] border-[#ccc] rounded p-1 m-2 w-[] outline-none transition-[border] duration-300 " type="number" name='totalRooms' value={hotel.totalRooms} onChange={handleChange} />
        {errors.totalRooms && <p>{errors.totalRooms}</p>}
        </div>

        <div className="flex flex-col" >
        <label>Available Rooms</label>
        <input className="border-[1px] border-[#ccc] rounded p-1 m-2 w-[] outline-none transition-[border] duration-300 " type="number" name='availableRooms' value={hotel.availableRooms} onChange={handleChange} />
        {errors.availableRooms && <p>{errors.availableRooms}</p>}
        </div>

        <div className="flex flex-col" >
        <label>Booked Rooms</label>
        <input className="border-[1px] border-[#ccc] rounded p-1 m-2 w-[] outline-none transition-[border] duration-300 " type="number" name='bookedRooms' value={hotel.bookedRooms} onChange={handleChange} />
        {errors.bookedRooms && <p>{errors.bookedRooms}</p>}
        </div>

        <div className="flex flex-col" >
        <label>Hotel Photo</label>
        <input className="border-[1px] border-[#ccc] rounded p-1 m-2 w-[] outline-none transition-[border] duration-300 " type="file" name='photo' onChange={(e) => setHotel({ ...hotel, photo: e.target.files[0] })}/>
        {errors.photo && <p>{errors.photo}</p>}
        </div>

        <div className="flex flex-col" >
        <label>Hotel Speciality</label>
        <input className="border-[1px] border-[#ccc] rounded p-1 m-2 w-[] outline-none transition-[border] duration-300 " type="text" name='hotelSpeciality' value={hotel.hotelSpeciality} onChange={handleChange} />
        {errors.hotelSpeciality && <p>{errors.hotelSpeciality}</p>}
        </div>

        <div className='flex flex-col'>
        <label>Room Available</label>
        <input className="border-[1px] border-[#ccc] rounded p-1 m-2 w-[25px] h-[25px] outline-none transition-[border] duration-300 " type="checkbox" name='isAvailable' checked={hotel.isAvailable} onChange={(e) => setHotel({ ...hotel, isAvailable: e.target.checked })} />
        {errors.isAvailable && <p>{errors.isAvailable}</p>}
        </div>

        <div className='flex justify-center items-center'>
        <button className='border border-[#ccc] py-1.5 px-2.5 rounded cursor-pointer bg-green-500 ' type="submit">Submit</button>
        </div>

      </form>

    </div>
  )
}

export default HotelDetails
