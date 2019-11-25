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
});
