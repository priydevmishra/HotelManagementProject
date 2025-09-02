import React, { useEffect, useRef, useState } from 'react'
import FirstHomePageSection from '../components/FirstHomePageSection'
import SecondHomePageSection from '../components/SecondHomePageSection'

const HomePage = () => {
const [hotels, setHotels] = useState([]);

useEffect(()=>{
  fetch("http://localhost:8080/")
  .then((res)=>res.json())
  .then((data)=>setHotels(data))
  .catch((err)=>console.error(err))
},[])
console.log(hotels);

  return (
    <>
    <FirstHomePageSection/>
    <SecondHomePageSection hotels={hotels}/>
    </>
  )
}

export default HomePage
