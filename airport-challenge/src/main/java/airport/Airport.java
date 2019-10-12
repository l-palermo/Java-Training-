package airport;

import java.util.ArrayList;

import airplane.Airplane;

import controlTower.ControlTower;

public class Airport
{
	ControlTower controlTower;
	
	public Airport(ControlTower ct){
		this.controlTower = ct;
	}
  ArrayList<Object> hangar = new ArrayList<Object>();

  public Object airplaneLand(Airplane airplane)
  {
    if (this.controlTower.checkForLand(hangar, airplane)) { return "The hangar is full"; }
    hangar.add(airplane);
    return hangar;
  }

  public Object airplaneTakeOff(Airplane airplane)
  {
    if (this.controlTower.checkForTakeOff(hangar, airplane)) { return "The airplane is not in the hangar"; }
    hangar.remove(airplane);
    return hangar;
  }
}
