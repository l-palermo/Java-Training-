package controlTower;

import java.util.ArrayList;

import airplane.Airplane;

public class ControlTower
{
  // insert control tower message to display reason of airplane not allowed 
  // to land or take off - Refactor conditional to smaller private methods
  public boolean checkForLand(ArrayList<Object> hangar, Airplane airplane, String weather)
  {
    if (checkHangarFull(hangar) || hangar.contains(airplane) || 
    airplane.atAirport() == true || weather == "stormy")
    {
     return true;
    }
    return false;
  }

  public boolean checkForTakeOff(ArrayList<Object> hangar, Airplane airplane, String weather)
  { 
    if (!hangar.contains(airplane) || airplane.atAirport() == false ||
    weather == "stormy")
    {
      return true;
    }
    return false;
  }
  private boolean checkHangarFull(ArrayList<Object> hangar)
  {
    if (hangar.size() >= 5) { return true; }
    return false;
  }
}
