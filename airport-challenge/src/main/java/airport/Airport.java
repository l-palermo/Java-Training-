package airport;

import java.util.ArrayList;

import airplane.Airplane;

import controlTower.ControlTower;
import weather.Weather;

public class Airport
{
  ControlTower controlTower;
  ArrayList<Object> hangar = new ArrayList<Object>();
  String weather;
	
	public Airport(ControlTower ct){
    this.controlTower = ct;
    this.weather = Weather.forecast();
	}

  public Object airplaneLand(Airplane airplane)
  {
    if (this.controlTower.checkForLand(hangar, airplane, weather)) { return "The hangar is full"; }
    airplane.land();
    hangar.add(airplane);
    return hangar;
  }

  public Object airplaneTakeOff(Airplane airplane)
  { System.out.println(this.controlTower);
    if (this.controlTower.checkForTakeOff(hangar, airplane, weather)) { return "The airplane is not in the hangar"; }
    airplane.takeOff();
    hangar.remove(airplane);
    return hangar;
  }
}
