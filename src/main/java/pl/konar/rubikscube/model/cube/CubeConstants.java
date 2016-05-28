package pl.konar.rubikscube.model.cube;

public class CubeConstants {

	public static int NUMBER_OF_FACES = 6;
	public static int NUMBER_OF_COLUMNS_PER_FACE = 3;
	public static int NUMBER_OF_ROWS_PER_FACE = 3;
	public static int NUMBER_OF_FACETS_PER_FACE = NUMBER_OF_COLUMNS_PER_FACE * NUMBER_OF_ROWS_PER_FACE;
	public static int NUMBER_OF_FACETS = NUMBER_OF_FACETS_PER_FACE * NUMBER_OF_FACES;

}
