package pl.konar.rubikscube.model.cube;

public class CubeConstants {

	public static final int NUMBER_OF_FACES = 6;
	public static final int NUMBER_OF_EDGES = 12;
	public static final int NUMBER_OF_CORNERS = 8;
	public static final int NUMBER_OF_COLUMNS_PER_FACE = 3;
	public static final int NUMBER_OF_ROWS_PER_FACE = 3;
	public static final int NUMBER_OF_FACETS_PER_FACE = NUMBER_OF_COLUMNS_PER_FACE * NUMBER_OF_ROWS_PER_FACE;
	public static final int NUMBER_OF_FACETS = NUMBER_OF_FACETS_PER_FACE * NUMBER_OF_FACES;
	public static final int NUMBER_OF_FACETS_PER_EDGE = 2;
	public static final int NUMBER_OF_FACETS_PER_CORNER = 3;

}
