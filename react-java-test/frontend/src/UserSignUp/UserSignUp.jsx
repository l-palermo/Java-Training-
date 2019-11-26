import React, { useState } from 'react';

export default function UserSignUp() {
  const [name, setName] = useState('');
  const onSubmit = () => {
    console.log('buuuuu');
  };
  return (
    <div>
      <input
        type="text"
        value={name}
        onChange={(e) => { setName(e.target.value); }}
      />
      <input type="submit" onClick={() => { onSubmit(); }} />
    </div>
  );
}
