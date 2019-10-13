package weather;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import weather.Weather;

public class WeatherTest
{
  @Test
  public void returnsTheWeatherForecast()
  {
    assertEquals("cloudy", Weather.forecast());
  }
}