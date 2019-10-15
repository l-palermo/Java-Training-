package airport;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import airplane.Airplane;
import controlTower.ControlTower;

public class AirportTest {
  ControlTower controlTowerMock;
  Airplane airplaneMock;
  String weatherMock;
  ArrayList<Object> hangarMock;

  @Before
  public void Initialize() {
    controlTowerMock = mock(ControlTower.class);
    airplaneMock = mock(Airplane.class);
    weatherMock = "";
    hangarMock = new ArrayList<>(Arrays.asList());
  }

  @Test
  public void returnsAnInstanceOfAirport() {
    Airport airport = new Airport(controlTowerMock);
    assertEquals(Airport.class, airport.getClass());
  }

  @Test
  public void returnsAnArrayWithTheLandedAirplane() {
    when(controlTowerMock.checkForLand(hangarMock, airplaneMock, weatherMock)).thenReturn(false);
    Airport airport = new Airport(controlTowerMock);
    airport.airplaneLand(airplaneMock);
    assertEquals(Arrays.asList(airplaneMock), airport.hangar);
  }

  @Test
  public void returnsAnArrayWithoutTheDepartedAirplane() {
    when(controlTowerMock.checkForTakeOff(hangarMock, airplaneMock, weatherMock)).thenReturn(false);
    Airport airport = new Airport(controlTowerMock);
    airport.hangar.add(airplaneMock);
    airport.airplaneTakeOff(airplaneMock);
    assertEquals(Arrays.asList(), airport.hangar);
  }

  //@Test
  public void AirplaneCannotLandIfHagarFull() {
    when(controlTowerMock.checkForLand(hangarMock, airplaneMock, weatherMock)).thenReturn(true);
    Airport airport = new Airport(controlTowerMock);
    assertEquals("The hangar is full", airport.airplaneLand(airplaneMock));
  }

  //@Test
  public void AirplaneCannotTakeOffIfNotInHangar() {
    doReturn(true).when(controlTowerMock).checkForTakeOff(hangarMock, airplaneMock, weatherMock);
    Airport airport = new Airport(controlTowerMock);
    //System.out.println("here");
    //System.out.println(airport.controlTower.checkForTakeOff(hangarMock, airplaneMock, weatherMock));
    assertEquals("The airplane is not in the hangar", airport.airplaneTakeOff(airplaneMock));
  } 
}