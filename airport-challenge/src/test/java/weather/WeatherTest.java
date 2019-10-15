package weather;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import weather.Weather;

public class WeatherTest
{
  @Test
  public void returnsTheWeatherForecastCloudy()
  {
    assertEquals("clear", Weather.forecast());
  }

  @Test
  public void returnsTheWeatherForecastClear()
  {
   assertEquals("clear", Weather.forecast());
  }
  @Test
  public void returnsTheWeatherForecastClearAgain()
  {
    assertEquals("stormy", Weather.forecast());
  }
  @Test
  public void returnsTheWeatherForecastCloudyAgain()
  {
    assertEquals("clear", Weather.forecast());
  }
}