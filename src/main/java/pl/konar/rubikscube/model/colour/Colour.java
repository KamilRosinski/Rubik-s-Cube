package pl.konar.rubikscube.model.colour;

public enum Colour {

//	BLUE, RED, ORANGE, GREEN, WHITE, YELLOW;
	
	TRANSPARENT("transparent"), WHITE("white"), RED("red"), BLUE("blue"), ORANGE("orange"), GREEN("green"), YELLOW("yellow");
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
	
}
