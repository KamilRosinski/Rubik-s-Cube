package pl.konar.rubikscube.model.colour;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum Colour {

	// BLUE, RED, ORANGE, GREEN, WHITE, YELLOW;

	TRANSPARENT("transparent"), WHITE("white"),GREEN("green"), ORANGE("orange"), BLUE("blue"), RED("red"), YELLOW(
			"yellow");
	private String colourName;

	private Colour(String colourName) {
		this.colourName = colourName;
	}

	@Override
	public String toString() {
		return colourName;
	}

	public Colour getNextColour() {
		return values()[(ordinal() + 1) % values().length];
	}

	public Colour getPreviousColour() {
		return values()[(ordinal() + values().length - 1) % values().length];
	}

	public static List<Colour> getAllNonTransparentList() {
		List<Colour> result = new ArrayList<>();
		for (Colour colour : values()) {
			if (Colour.TRANSPARENT != colour) {
				result.add(colour);
			}
		}
		return result;
	}

	public static Set<Colour> getAllNonTransparentSet() {
		return new HashSet<>(getAllNonTransparentList());
	}
	
}
