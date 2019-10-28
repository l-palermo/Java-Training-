import React from 'react';

export default class ParentComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      text: ''
    }
  }

  componentDidMount() {
    fetch('/first')
    .then(response => response.text())
    .then(text => this.setState({ text: text }))
  }
  render() {
    return(
      <div>
      <div>
        <h1>This is one route</h1>
        <h1>gets data from the backend</h1>
        <h1>from the route '/first' </h1>
      </div>
      <div>
        { this.state.text}
      </div>
      </div>
    )
  }
}