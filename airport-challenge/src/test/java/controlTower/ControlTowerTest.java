package controlTower;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import airplane.Airplane;

public class controlTowerTest
{ 
  ControlTower ControlTower;
  Airplane airplane;
  String weather;
  @Before public void initialize()
  {
    ControlTower = new ControlTower();
    airplane = mock(Airplane.class);
    weather = "clear";
  }
  
  @Test
  public void checkForLandReturnsFalseIfClearForLand()
  {
    Object[] hangarFull = new Object[1];
    ArrayList<Object> hangar = new ArrayList<>(Arrays.asList(hangarFull));
    assertEquals(false, ControlTower.checkForLand(hangar, airplane, weather));
  }
    @Test
    public void checkIfHangarContainsAirplane()
    {
      Object[] hangarFull = new Object[1];
      hangarFull[0] = airplane;
      ArrayList<Object> hangar = new ArrayList<>(Arrays.asList(hangarFull));
      assertEquals(true, ControlTower.checkForLand(hangar, airplane, weather));
    }
    @Test
    public void checkIfHangarIsFull()
    {
      Object[] hangarFull = new Object[5];
      ArrayList<Object> hangar = new ArrayList<>(Arrays.asList(hangarFull));
      assertEquals(true, ControlTower.checkForLand(hangar, airplane, weather));
    }
    @Test
    public void checkIfAirplaneIsAtAirport()
    {
      when(airplane.atAirport()).thenReturn(true);
      Object[] hangarFull = new Object[2];
      ArrayList<Object> hangar = new ArrayList<>(Arrays.asList(hangarFull));
      assertEquals(true, ControlTower.checkForLand(hangar, airplane, weather));
    }
    @Test
    public void checkIfWeatherIsStormyForLand()
    {
      Object[] hangarFull = new Object[2];
      ArrayList<Object> hangar = new ArrayList<>(Arrays.asList(hangarFull));
      weather = "stormy";
      assertEquals(true, ControlTower.checkForLand(hangar, airplane, weather));
    }
  @Test
  public void checkForTakeOffReturnsTrueIfClearForTakeOff()
  {
    Object[] hangarFull = new Object[1];
    hangarFull[0] = airplane;
    doReturn(true).when(airplane).atAirport();
    ArrayList<Object> hangar = new ArrayList<>(Arrays.asList(hangarFull));
    assertEquals(false, ControlTower.checkForTakeOff(hangar, airplane, weather));
  }
    @Test
    public void checkIfHangarNotContainsAirplane()
    {
      Object[] hangarFull = new Object[1];
      ArrayList<Object> hangar = new ArrayList<>(Arrays.asList(hangarFull));
      assertEquals(true, ControlTower.checkForTakeOff(hangar, airplane, weather));
    }
    @Test
    public void checkIfAirplaneIsNotAtAirport()
    {
      when(airplane.atAirport()).thenReturn(false);
      Object[] hangarFull = new Object[1];
      hangarFull[0] = airplane;
      ArrayList<Object> hangar = new ArrayList<>(Arrays.asList(hangarFull));
      assertEquals(true, ControlTower.checkForTakeOff(hangar, airplane, weather));
    }
    @Test
    public void checkIfWeatherIsStormyForTakeOff()
    {
      Object[] hangarFull = new Object[2];
      ArrayList<Object> hangar = new ArrayList<>(Arrays.asList(hangarFull));
      weather = "stormy";
      assertEquals(true, ControlTower.checkForLand(hangar, airplane, weather));
    }
}
