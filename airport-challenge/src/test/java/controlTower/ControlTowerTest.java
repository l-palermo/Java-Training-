package controlTower;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.Test;

import airplane.Airplane;

public class ControlTowerTest
{
  @Test
  public void returnsTrueIfClearForLand()
  {
    Airplane airplane = mock(Airplane.class);
    Object[] hangarFull = new Object[1];
    ArrayList<Object> hangar = new ArrayList<>(Arrays.asList(hangarFull));
    assertEquals(true, controlTower.checkForLand(hangar, airplane));
  }
  @Test
  public void checkIfHangarContainsAirplane()
  {
    Airplane airplane = mock(Airplane.class);
    Object[] hangarFull = new Object[1];
    hangarFull[0] = airplane;
    ArrayList<Object> hangar = new ArrayList<>(Arrays.asList(hangarFull));
    assertEquals(false, controlTower.checkForLand(hangar, airplane));
  }
  @Test
  public void checkIfHangarIsFull()
  {
    Airplane airplane = mock(Airplane.class);
    Object[] hangarFull = new Object[5];
    ArrayList<Object> hangar = new ArrayList<>(Arrays.asList(hangarFull));
    assertEquals(false, controlTower.checkForLand(hangar, airplane));
  }
  @Test
  public void checkIfAirplaneIsAtAirport()
  {
    Airplane airplane = mock(Airplane.class);
    airplane.atAirport = true;
    System.out.println(airplane);
    Object[] hangarFull = new Object[5];
    ArrayList<Object> hangar = new ArrayList<>(Arrays.asList(hangarFull));
    assertEquals(false, controlTower.checkForLand(hangar, airplane));
  }
}

