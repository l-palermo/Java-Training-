package airport;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import airplane.Airplane;

public class AirportTest
{
  @Test
  public void returnsAnInstanceOfAirport()
  {
    Airport airport = new Airport();

    assertEquals(Airport.class, airport.getClass());
  }
  @Test
  public void returnsAnArrayWithTheLandedAirplane()
  {
    Airport airport = new Airport();
    Airplane airplane = new Airplane();
    airport.airplaneLand(airplane);
    assertEquals(Arrays.asList(airplane), airport.hangar);
  }
  @Test
  public void returnsAnArrayWithoutTheDepartedAirplane()
  {
    Airport airport = new Airport();
    Airplane airplane = new Airplane();
    airport.hangar.add(airplane);
    airport.airplaneTakeOff(airplane);
    assertEquals(Arrays.asList(), airport.hangar);
  }
}