import React from 'react';
import BackendData from '../BackendData/BackendData';

export default class ParentComponents extends React.Component {
  render() {
    return(
      <div>
        <BackendData />
      </div>
    )
  }
}