import React from 'react'

const Search = () => {
  return (
    <form className='mt-7 flex justify-center'>
      <input className='border-[#ccc] border-[1px] rounded p-1.5 w-xl text-center' type="text" placeholder='Search Here'/>
      <button className='border-[1px] border-green-500 p-1.5 rounded ml-1 text-green-500 bg-white hover:bg-green-500 hover:text-black cursor-pointer'>Search</button>
    </form>
  )
}

export default Search;
