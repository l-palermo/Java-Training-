package hangar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import airplane.Airplane;

public class HangarTest
{
  Hangar hangar;
  Airplane airplaneMock;

  @Before
  public void initialize() {
    hangar = new Hangar();
    airplaneMock = mock(Airplane.class);
  }
  @Test
  public void returnsAnInstanceOfHangar()
  {
    assertEquals(Hangar.class, hangar.getClass());
  }
  @Test
  public void hangarHasDefaultCapacity()
  {
    assertEquals(5, hangar.capacity);
  }
  @Test
  public void addAirplaneStoresAnInstanceOfAirplane()
  {
    hangar.addAirplane(airplaneMock);
    assertEquals(Arrays.asList(airplaneMock), hangar.hangar);
  }
  @Test
  public void removeAirplaneRemovesInstanceOffAirplane()
  { 
    hangar.addAirplane(airplaneMock);  
    hangar.removeAirplane(airplaneMock);
    assertEquals(Arrays.asList(), hangar.hangar);
  }
  @Test
  public void capacityOverride()
  {
    hangar.capacityOverride(2);
    assertEquals(2, hangar.capacity);
  }
}
