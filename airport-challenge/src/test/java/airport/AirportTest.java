package airport;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import airplane.Airplane;
import controlTower.ControlTower;

public class AirportTest
{
  ControlTower controlTower;
  Airplane airplaneMock;
  @Before
  public void Initialize()
	{
    controlTower = mock(ControlTower.class);
    airplaneMock = mock(Airplane.class);
	}
  
  @Test
  public void returnsAnInstanceOfAirport()
  { 
    Airport airport = new Airport(controlTower);
    assertEquals(Airport.class, airport.getClass());
  }
  @Test
  public void returnsAnArrayWithTheLandedAirplane()
  {
    Airport airport = new Airport(controlTower);
    airport.airplaneLand(airplaneMock);
    assertEquals(Arrays.asList(airplaneMock), airport.hangar);
  }
  @Test
  public void returnsAnArrayWithoutTheDepartedAirplane()
  {
    ArrayList<Object> hangarMock = new ArrayList<>(Arrays.asList());
    when(controlTower.checkForLand(hangarMock, airplaneMock)).thenReturn(true);
    Airport airport = new Airport(controlTower);
    airport.hangar.add(airplaneMock);
    airport.airplaneTakeOff(airplaneMock);
    assertEquals(Arrays.asList(), airport.hangar);
  }
  @Test
  public void AirplaneCannotLandIfHagarFull()
  {
    ArrayList<Object> hangarMock = new ArrayList<>(Arrays.asList());
    when(controlTower.checkForLand(hangarMock, airplaneMock)).thenReturn(true);
    Airport airport = new Airport(controlTower);
    assertEquals("The hangar is full", airport.airplaneLand(airplaneMock));
  }
  @Test
  public void AirplaneCannotTakeOffIfNotInHangar()
  {
    Airport airport = new Airport(controlTower);
    assertEquals("The airplane is not in the hangar", airport.airplaneTakeOff(airplaneMock));
  }
}