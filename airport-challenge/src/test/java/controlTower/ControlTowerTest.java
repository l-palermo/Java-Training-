package controlTower;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import airplane.Airplane;
import hangar.Hangar;

public class controlTowerTest
{ 
  ControlTower ControlTower;
  Airplane airplaneMock;
  Airplane airplaneMock1;
  String weather;
  Hangar hangarMock;
  
  @Before public void initialize()
  {
    ControlTower = new ControlTower();
    airplaneMock = mock(Airplane.class);
    airplaneMock1 = mock(Airplane.class);
    hangarMock = mock(Hangar.class);
    hangarMock.hangar = new ArrayList<Airplane>();
    hangarMock.capacity = 5;
    weather = "clear";
  }
  
  @Test
  public void checkForLandReturnsFalseIfClearForLand()
  {
    assertEquals(false, ControlTower.checkForLand(hangarMock, airplaneMock, weather));
  }
    @Test
    public void checkIfHangarIncludesAirplane()
    {
      hangarMock.hangar.add(airplaneMock);
      assertEquals(true, ControlTower.checkForLand(hangarMock, airplaneMock, weather));
    }
    @Test
    public void checkIfHangarIsFull()
    {
      hangarMock.capacity = 1;
      hangarMock.hangar.add(airplaneMock);
      assertEquals(true, ControlTower.checkForLand(hangarMock, airplaneMock1, weather));
    }
    @Test
    public void checkIfAirplaneIsAtAirport()
    {
      when(airplaneMock.atAirport()).thenReturn(true);
      assertEquals(true, ControlTower.checkForLand(hangarMock, airplaneMock, weather));
    }
    @Test
    public void checkIfWeatherIsStormyForLand()
    {
      weather = "stormy";
      assertEquals(true, ControlTower.checkForLand(hangarMock, airplaneMock, weather));
    }
  @Test
  public void checkForTakeOffReturnsTrueIfClearForTakeOff()
  {
    hangarMock.hangar.add(airplaneMock);
    doReturn(true).when(airplaneMock).atAirport();
    assertEquals(false, ControlTower.checkForTakeOff(hangarMock, airplaneMock, weather));
  }
    @Test
    public void checkIfHangarNotIncludesAirplane()
    {
      doReturn(true).when(airplaneMock).atAirport();
      assertEquals(true, ControlTower.checkForTakeOff(hangarMock, airplaneMock, weather));
    }

    @Test
    public void checkIfAirplaneIsNotAtAirport()
    {
      hangarMock.hangar.add(airplaneMock);
      when(airplaneMock.atAirport()).thenReturn(false);
      assertEquals(true, ControlTower.checkForTakeOff(hangarMock, airplaneMock, weather));
    }

    @Test
    public void checkIfWeatherIsStormyForTakeOff()
    {
      weather = "stormy";
      hangarMock.hangar.add(airplaneMock);
      doReturn(true).when(airplaneMock).atAirport();
      assertEquals(true, ControlTower.checkForTakeOff(hangarMock, airplaneMock, weather));
    }
}
