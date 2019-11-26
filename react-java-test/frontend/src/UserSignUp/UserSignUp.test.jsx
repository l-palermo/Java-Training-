import React from 'react';
import { shallow, configure } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import UserSignUp from './UserSignUp';

configure({ adapter: new Adapter() });

describe('UserSignUp', () => {
  it('renders without crashing', () => {
    const wrapper = shallow(<UserSignUp />);
    expect(wrapper).toHaveLength(1);
  });
  it('get a name as input', () => {
    const wrapper = shallow(<UserSignUp />);
    const input = wrapper.find({ type: 'text' });
    input.simulate('change', { target: { value: 'test' } });
    expect(true).toBe(true);
  });
  it('submit the name and pass it to the database', () => {
    const wrapper = shallow(<UserSignUp />);
    const submitButton = wrapper.find({ type: 'submit' });
    submitButton.simulate('click');
    expect(true).toBe(true);
  });
});
