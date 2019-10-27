import React from 'react';
import BackendData from './BackendData';
import { shallow, configure } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import { render } from '@testing-library/react';
import fetch from './fetchMock';
global.fetch = fetch;

configure({ adapter: new Adapter() })
jest.useFakeTimers();

describe('#BackendData', () => {
  it('renders without crashing', () => {
    const wrapper = shallow(<BackendData />);
    expect(wrapper).toHaveLength(1);
  });
  describe('hello function', () => {
    it('fetches the data from the backend', () => {
      const fetchSpy = jest.spyOn(window, 'fetch');
      render(<BackendData />);
      expect(fetchSpy).toHaveBeenCalled();
    })
  })
});