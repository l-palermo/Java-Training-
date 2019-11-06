package airport;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import airplane.Airplane;
import controlTower.ControlTower;

@RunWith(MockitoJUnitRunner.class)

public class AirportTest {

  @Rule
  public MockitoRule rule = MockitoJUnit.rule();

  @Mock
  private ControlTower controlTowerMock;

  @InjectMocks
  Airport airport;

  Airplane airplaneMock;
  String weatherMock;
  ArrayList<Object> hangarMock;

  @Before
  public void setup()
  {
    airplaneMock = mock(Airplane.class);
  }

  @Test
  public void returnsAnInstanceOfAirport() {
    assertEquals(Airport.class, airport.getClass());
  }

  @Test
  public void returnsAnArrayWithTheLandedAirplane() {
    airport.airplaneLand(airplaneMock);
    assertEquals(Arrays.asList(airplaneMock), airport.hangar);
  }

  @Test
  public void returnsAnArrayWithoutTheDepartedAirplane() {
    when(controlTowerMock.checkForTakeOff(any(ArrayList.class), any(Airplane.class), anyString())).thenReturn(false);
    airport.airplaneTakeOff(airplaneMock);
    assertEquals(Arrays.asList(), airport.hangar);
  }

  @Test
  public void AirplaneCannotLandIfHagarFull() {
    when(controlTowerMock.checkForLand(any(ArrayList.class), any(Airplane.class), anyString())).thenReturn(true);
    assertEquals("The airplane cannot land", airport.airplaneLand(airplaneMock));
  }

  @Test
  public void AirplaneCannotTakeOffIfNotInHangar() {
    when(controlTowerMock.checkForTakeOff(any(ArrayList.class), any(Airplane.class), anyString())).thenReturn(true);
    assertEquals("The airplane is not in the hangar", airport.airplaneTakeOff(airplaneMock));
  } 
}
