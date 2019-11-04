import React from 'react';
import { shallow, configure } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import FirstRoute from './FirstRoute';
import fetch from '../SecondRoute/fetchMock';
global.fetch = fetch;

configure({ adapter: new Adapter() });

describe('FirstRoute', () => {
  it('renders without crash', () => {
    const wrapper = shallow(<FirstRoute />);
    expect(wrapper).toHaveLength(1);
  })
  describe('#componentDidMount', () => {
    it('fetches the data from the backend', () => {
      const fetchSpy = jest.spyOn(window, 'fetch');
      shallow(<FirstRoute />);
      expect(fetchSpy).toHaveBeenCalled();
    })
  })
})