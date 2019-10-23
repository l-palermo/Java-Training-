import React from 'react';
import BackendData from './BackendData';
import { shallow, configure } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';

configure({ adapter: new Adapter() })

describe('#BackendData', () => {
  it('renders without crashing', () => {
    const wrapper = shallow(<BackendData />);
    expect(wrapper).toHaveLength(1);
  });
});