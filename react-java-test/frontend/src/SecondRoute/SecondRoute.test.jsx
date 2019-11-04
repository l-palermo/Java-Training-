import React from 'react';
import SecondRoute from './SecondRoute';
import { shallow, configure } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import { render } from '@testing-library/react';
import fetch from './fetchMock';
global.fetch = fetch;

configure({ adapter: new Adapter() })
jest.useFakeTimers();

describe('#SecondRoute', () => {
  it('renders without crashing', () => {
    const wrapper = shallow(<SecondRoute />);
    expect(wrapper).toHaveLength(1);
  });
  describe('hello function', () => {
    it('fetches the data from the backend', () => {
      const fetchSpy = jest.spyOn(window, 'fetch');
      render(<SecondRoute />);
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