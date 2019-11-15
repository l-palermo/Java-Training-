package airport;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.*;

import airplane.Airplane;
import controlTower.ControlTower;
import hangar.Hangar;

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
  Hangar hangarMock;

  @Before
  public void setup()
  {
    airplaneMock = mock(Airplane.class);
  }
  @Test
  public void returnsAnInstanceOfAirport()
  {
    assertEquals(Airport.class, airport.getClass());
  }
  @Test
  public void returnsAnArrayWithTheLandedAirplane()
  {
    airport.airplaneLand(airplaneMock);
    assertEquals(airport.airplaneLand(airplaneMock), "The airplane has succesfully landed");
  }
  @Test
  public void returnsAnArrayWithoutTheDepartedAirplane()
  {
    when(controlTowerMock.checkForTakeOff(any(Hangar.class), any(Airplane.class), anyString())).thenReturn(false);
    assertEquals(airport.airplaneTakeOff(airplaneMock), "The airplane has succesfully taken off");
  }
  @Test
  public void AirplaneCannotLandIfHagarFull()
  {
    when(controlTowerMock.checkForLand(any(Hangar.class), any(Airplane.class), anyString())).thenReturn(true);
    assertEquals("The airplane cannot land", airport.airplaneLand(airplaneMock));
  }
  @Test
  public void AirplaneCannotTakeOffIfNotInHangar()
  {
    when(controlTowerMock.checkForTakeOff(any(Hangar.class), any(Airplane.class), anyString())).thenReturn(true);
    assertEquals("The airplane cannot take-off", airport.airplaneTakeOff(airplaneMock));
  } 
}
