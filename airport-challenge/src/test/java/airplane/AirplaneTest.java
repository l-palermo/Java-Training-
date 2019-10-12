package airplane;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AirplaneTest
{
  @Test
  public void returnsAnInstanceOfAirplane()
  {
    Airplane plane = new Airplane();

    assertEquals(Airplane.class, plane.getClass());
  }
  @Test
  public void whenAirplaneLandReturnsTrue()
  {
    Airplane plane = new Airplane();
    plane.land();

    assertEquals(true, plane.atAirport());
  }
  @Test
  public void whenAirplaneTakeOffReturnsFalse()
  {
    Airplane plane = new Airplane();
    plane.takeOff();

    assertEquals(false, plane.atAirport());
  }
}