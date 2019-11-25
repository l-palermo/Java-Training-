import React, { useState, useEffect } from 'react';

export default function SecondRoute() {
  const [message, setMessage] = useState('');

  useEffect(() => {
    fetch('/api')
      .then((response) => response.text())
      .then((text) => {
        setMessage(text);
      });
  }, []);

  return (
    <div data-testid="message">
      { message }
    </div>
  );
}
