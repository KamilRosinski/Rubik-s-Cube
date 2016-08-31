package pl.konar.rubikscube.model.cube.exception;

public class WrongNumberOfFacetsException extends RuntimeException {

	private static final long serialVersionUID = 106145166689530369L;

	public WrongNumberOfFacetsException(String message) {
		super(message);
	}

}
