package airport;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import airplane.Airplane;

import static org.mockito.Mockito.*;

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
    Airplane airplaneMock = mock(Airplane.class);
    airport.airplaneLand(airplaneMock);
    assertEquals(Arrays.asList(airplaneMock), airport.hangar);
  }
  @Test
  public void returnsAnArrayWithoutTheDepartedAirplane()
  {
    Airport airport = new Airport();
    Airplane airplaneMock = mock(Airplane.class);
    airport.hangar.add(airplaneMock);
    airport.airplaneTakeOff(airplaneMock);
    assertEquals(Arrays.asList(), airport.hangar);
  }
  @Test
  public void AirplaneCannotLandIfHagarFull()
  {
    Airport airport = new Airport();
    Airplane airplaneMock = mock(Airplane.class);
    Object[] hangarFull = new Object[5];
    airport.hangar = new ArrayList<>(Arrays.asList(hangarFull));
    assertEquals("The hangar is full", airport.airplaneLand(airplaneMock));
  }
}