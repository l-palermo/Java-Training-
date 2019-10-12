package airplane;

public class Airplane
{
  public boolean atAirport = false;

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