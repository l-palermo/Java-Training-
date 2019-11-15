package weather;

import static org.junit.Assert.assertEquals;
import static weather.Weather.random;

import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherTest
{
  @BeforeClass
  public static void intialize()
  {
    random.setSeed(25456);
  }
  @Test
  public void returnsTheWeatherForecastCloudy() 
  {
    assertEquals("stormy", Weather.forecast());
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