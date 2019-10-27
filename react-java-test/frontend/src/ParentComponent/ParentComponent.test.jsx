import React from 'react';
import { shallow, configure } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import ParentComponent from './ParentComponent';
import BackendData from '../BackendData/BackendData';

configure({ adapter: new Adapter() });

describe('ParentComponent', () => {
  it('renders without crash', () => {
    const wrapper = shallow(<ParentComponent />);
    expect(wrapper).toHaveLength(1);
  })
  it('renders the BackendData component', () => {
    const wrapper = shallow(<ParentComponent />)
    const backendData = wrapper.find(BackendData);
    expect(backendData).toHaveLength(1);
  })
})