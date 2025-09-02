import React from 'react'

export default function Header(props){
  return (
    <div className='w-full bg-blue-50 rounded-b-4xl p-6'>
      <h1 className='text-center text-2xl font-bold '>{props.text}</h1>
    </div>
  )
}

