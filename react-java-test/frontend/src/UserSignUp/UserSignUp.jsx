import React, { useState } from 'react';

export default function UserSignUp() {
  const [name, setName] = useState('');

  return (
    <div>
      <input type="text" value="name" onChange={() => { setName(name); }} />
    </div>
  );
}
