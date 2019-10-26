import React, { useState, useEffect } from 'react';

export default function BackendData() {
  const [message, setMessage] = useState('');

  useEffect(() => {
    setInterval(hello(), 250);
  });

  let hello = () => {
    fetch('/api')
    .then(response => response.text())
    .then(message => {
      setMessage(message)
    })
  }

  return (
    <div>
      { message }
    </div>
  )
}