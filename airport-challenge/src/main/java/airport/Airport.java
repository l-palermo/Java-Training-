package airport;

import airplane.Airplane;

import java.util.ArrayList;

public class Airport
{
  ArrayList<Object> hangar = new ArrayList<Object>();

  public Object airplaneLand(Airplane airplane)
  {
    if (hangar.size() == 5) { return "The hangar is full"; }
    hangar.add(airplane);
    return hangar;
  }

  public Object airplaneTakeOff(Airplane airplane)
  {
    if (!hangar.contains(airplane)) { return "The airplane is not in the hangar"; }
    hangar.remove(airplane);
    return hangar;
  }
}
