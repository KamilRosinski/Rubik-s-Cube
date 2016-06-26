package pl.konar.rubikscube.model.cube.exception;

public class CubeNotSolvableException extends RuntimeException {

	private static final long serialVersionUID = 4110678795778911503L;

	public CubeNotSolvableException(String message) {
		super(message);
	}

}
