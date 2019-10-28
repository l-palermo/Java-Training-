import React, { useState, useEffect } from 'react';

export default function BackendData() {
  const [message, setMessage] = useState('');

  useEffect(() => {
    fetch('/api')
    .then(response => {
      return response.text()
    })
    .then(message => {
      setMessage(message)
    })
  }, []);

  return (
    <div data-testid="message">
      { message }
    </div>
  )
}