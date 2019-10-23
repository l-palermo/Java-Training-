import React, { useState, useEffect } from 'react';

export default function BackendData() {
  const [message] = useState('');

  useEffect(() => {
    setInterval(this.hello, 250);
  });

  return (
    <div>

    </div>
  )
}