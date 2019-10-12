package controlTower;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.*;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import airplane.Airplane;

public class ControlTowerTest
{ 
  @Rule
  public MockitoRule rule = MockitoJUnit.rule();
  
  @Mock
  private Airplane airplane;
  
  @Test
  public void checkForLandReturnsTrueIfClearForLand()
  {
    Object[] hangarFull = new Object[1];
    ArrayList<Object> hangar = new ArrayList<>(Arrays.asList(hangarFull));
    assertEquals(true, controlTower.checkForLand(hangar, airplane));
  }
    @Test
    public void checkIfHangarContainsAirplane()
    {
      Object[] hangarFull = new Object[1];
      hangarFull[0] = airplane;
      ArrayList<Object> hangar = new ArrayList<>(Arrays.asList(hangarFull));
      assertEquals(false, controlTower.checkForLand(hangar, airplane));
    }
    @Test
    public void checkIfHangarIsFull()
    {
      Object[] hangarFull = new Object[5];
      ArrayList<Object> hangar = new ArrayList<>(Arrays.asList(hangarFull));
      assertEquals(false, controlTower.checkForLand(hangar, airplane));
    }
    @Test
    public void checkIfAirplaneIsAtAirport()
    {
      when(airplane.atAirport()).thenReturn(true);
      Object[] hangarFull = new Object[2];
      ArrayList<Object> hangar = new ArrayList<>(Arrays.asList(hangarFull));
      assertEquals(false, controlTower.checkForLand(hangar, airplane));
    }
  @Test
  public void checkForTakeOffReturnsTrueIfClearForTakeOff()
  {
    Object[] hangarFull = new Object[1];
    when(airplane.atAirport()).thenReturn(true);
    hangarFull[0] = airplane;
    ArrayList<Object> hangar = new ArrayList<>(Arrays.asList(hangarFull));
    assertEquals(true, controlTower.checkForTakeOff(hangar, airplane));
  }
    @Test
    public void checkIfHangarNotContainsAirplane()
    {
      Object[] hangarFull = new Object[1];
      ArrayList<Object> hangar = new ArrayList<>(Arrays.asList(hangarFull));
      assertEquals(false, controlTower.checkForTakeOff(hangar, airplane));
    }
    @Test
    public void checkIfAirplaneIsNotAtAirport()
    {
      when(airplane.atAirport()).thenReturn(false);
      Object[] hangarFull = new Object[1];
      hangarFull[0] = airplane;
      ArrayList<Object> hangar = new ArrayList<>(Arrays.asList(hangarFull));
      assertEquals(false, controlTower.checkForTakeOff(hangar, airplane));
    }
}
