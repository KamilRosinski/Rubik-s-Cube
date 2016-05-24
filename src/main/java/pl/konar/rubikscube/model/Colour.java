package pl.konar.rubikscube.model;

public enum Colour {

//	BLUE, RED, ORANGE, GREEN, WHITE, YELLOW;
	
	TRANSPARENT("transparent"), BLUE("blue"), RED("red"), ORANGE("orange"), GREEN("green"), WHITE("white"), YELLOW("yellow");
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
	
}
