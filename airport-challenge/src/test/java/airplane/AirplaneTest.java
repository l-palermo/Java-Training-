package airplane;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AirplaneTest
{
  @Test
  public void shouldReturnAnInstanceOfAirplane()
  {
    Airplane plane = new Airplane();

    assertEquals(Airplane.class, plane.getClass());
  }
  @Test
  public void whenAirplaneLandReturnsTrue()
  {
    Airplane plane = new Airplane();

    assertEquals(true, plane.land());
  }
}