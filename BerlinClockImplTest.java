package berlinClock;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BerlinClockImplTest {

	@Test
	public void testBerlinClockJustBeforeMidnightScenario() {
		String expected = "0\n" + "RRRR\n" + "RRR0\n" + "YYRYYRYYRYY\n" + "YYYY";
		assertEquals(expected, new BerlinClockImpl().convertTime("23:59:59"));
	}

	@Test
	public void testBerlinClockMidnightScenario() {
		String expected = "Y\n" + "0000\n" + "0000\n" + "00000000000\n" + "0000";
		assertEquals (expected , new BerlinClockImpl().convertTime("00:00:00"));
	}
	
	@Test
	public void testMiddleOfTheAfternoonScenario(){
		String expected = "0\n" + "RR00\n" + "RRR0\n" + "YYR00000000\n" + "YY00";
		assertEquals (expected , new BerlinClockImpl().convertTime("13:17:01"));
	}

	@Test
	public void testBerlinClockAnotherMidnightScenario() {
		String expected = "Y\n" + "RRRR\n" + "RRRR\n" + "00000000000\n" + "0000";
		assertEquals (expected , new BerlinClockImpl().convertTime("24:00:00"));
	}
}
