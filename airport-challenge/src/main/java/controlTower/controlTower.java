package controlTower;

import java.util.ArrayList;

import airplane.Airplane;

class controlTower
{
  public static boolean checkForLand(ArrayList<Object> hangar, Airplane airplane)
  {
    if (hangar.size() == 5 || hangar.contains(airplane) || 
    airplane.atAirport() == true)
    {
     return false;
    }
    return true;
  }

  public static boolean checkForTakeOff(ArrayList<Object> hangar, Airplane airplane)
  {
    if (!hangar.contains(airplane) || airplane.atAirport() == false)
    {
      return false;
    }
    return true;
  }
}
