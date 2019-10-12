package airplane;

public class Airplane
{
  private boolean atAirport = false;

  public boolean atAirport()
  {
    return atAirport;
  }

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