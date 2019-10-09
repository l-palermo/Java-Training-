package airport;

import java.util.ArrayList;

public class Airport
{
  ArrayList<Object> hangar = new ArrayList<Object>();

  public Object airplaneLand(Object airplane)
  {
    hangar.add(airplane);
    return hangar;
  }

  public Object airplaneTakeOff(Object airplane)
  {
    hangar.remove(airplane);
    return hangar;
  }
}
