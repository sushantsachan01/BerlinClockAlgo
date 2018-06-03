package berlinClock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Sushant Sachan
 *
 */
public class BerlinClockImpl implements TimeConverter {

	@Override
	public String convertTime(String aTime) {

		List<Integer> parts = new ArrayList<Integer>();
		for (String part : aTime.split(":")) {
			parts.add(Integer.parseInt(part));
		}

		String secondsLight = (parts.get(2) % 2 == 0) ? "Y" : "0";
		String topHoursLights = createBerlinClockRowString(parts.get(0) / 5, 4, "R");
		String bottomHoursLights = createBerlinClockRowString(parts.get(0) % 5, 4, "R");
		String topMinutesLights = createBerlinClockRowString(parts.get(1) / 5, 11, "Y").replaceAll("YYY", "YYR");
		String bottomMinutesLights = createBerlinClockRowString(parts.get(1) % 5, 4, "Y");

		return String.join("\n", Arrays.asList(secondsLight, topHoursLights, bottomHoursLights, topMinutesLights, bottomMinutesLights));
	}

	/**
	 * Creates a string for each row of the berlin clock.
	 * 
	 * @param illuminatedLights total no. of lights illuminated.
	 * @param totalLightsInRow total no. of lights in the row.
	 * @param lampType type of light.
	 * @return A string representing a single row of the clock.
	 */
	private String createBerlinClockRowString(int illuminatedLights, int totalLightsInRow, String lampType) {

		int unlitLights = totalLightsInRow - illuminatedLights;
		String illuminatedLight = String.join("", Collections.nCopies(illuminatedLights, lampType));
		String unlit = String.join("", Collections.nCopies(unlitLights, "0"));

		return illuminatedLight + unlit;
	}
}
