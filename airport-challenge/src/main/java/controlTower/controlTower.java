package controlTower;

import java.util.ArrayList;

import airplane.Airplane;

public class ControlTower
{
  public static boolean checkForLand(ArrayList<Object> hangar, Airplane airplane)
  {
    if (hangar.size() == 5 || hangar.contains(airplane) || 
    airplane.atAirport() == true)
    {
     return true;
    }
    return false;
  }

  public static boolean checkForTakeOff(ArrayList<Object> hangar, Airplane airplane)
  {
    if (!hangar.contains(airplane) || airplane.atAirport() == false)
    {
      return true;
    }
    return false;
  }
}
