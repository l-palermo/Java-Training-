package airplane;

public class Airplane
{
  boolean atAirport = false;

  public boolean land()
  {
    atAirport = true;
    return atAirport;
  }

  public boolean takeOff()
  {
    atAirport = false;
    return atAirport;
  }
}