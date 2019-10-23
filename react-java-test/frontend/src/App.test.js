import React from 'react';
import { shallow, configure } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import App from './App';
import BackendData from './BackendData/BackendData';

configure({ adapter: new Adapter() })

it('renders without crashing', () => {
  const wrapper = shallow(<App />);
  expect(wrapper).toHaveLength(1);
});

it('renders BackendData component', () => {
  const wrapper = shallow(<App />);
  const component = wrapper.find(BackendData);
  expect(component).toHaveLength(1);
});
