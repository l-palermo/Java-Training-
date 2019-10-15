package airport;

import java.util.ArrayList;

import airplane.Airplane;

import controlTower.ControlTower;
import weather.Weather;

public class Airport
{
  ControlTower controlTower;
  ArrayList<Object> hangar = new ArrayList<Object>();
  private String weather;
	
	public Airport(ControlTower ct){
    this.controlTower = ct;
    this.weather = Weather.forecast();
	}

  public Object airplaneLand(Airplane airplane)
  {
    if (ControlTower.checkForLand(hangar, airplane)) { return "The hangar is full"; }
    airplane.land();
    hangar.add(airplane);
    return hangar;
  }

  public Object airplaneTakeOff(Airplane airplane)
  {
    if (ControlTower.checkForTakeOff(hangar, airplane)) { return "The airplane is not in the hangar"; }
    airplane.takeOff();
    hangar.remove(airplane);
    return hangar;
  }
}
