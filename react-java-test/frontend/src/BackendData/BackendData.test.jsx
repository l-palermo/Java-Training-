import React from 'react';
import BackendData from './BackendData';
import { shallow, configure } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import { render, getByTestId, queryByDisplayValue, queryByPlaceholderText } from '@testing-library/react';
import fetch from './fetchMock';
import { act } from 'react-dom/test-utils';
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
/* it('returns the text hello', () => {
  const fetchSpy = jest.spyOn(window, 'fetch');
  const { container } = render(<BackendData />)
  act(() => { setMessage('hello')})
  const message = getByTestId(container, 'message')
  expect(message.textContent).toBe('hello')
}) */