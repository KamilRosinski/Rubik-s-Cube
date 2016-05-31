package pl.konar.rubikscube.model.cube.cubicle;

import java.util.Arrays;
import java.util.List;

import pl.konar.rubikscube.model.colour.Colour;

public class Cubicle {

	private final List<Colour> facets;

	public Cubicle(Colour... colours) {
		facets = Arrays.asList(colours);
	}

	public List<Colour> getColours() {
		return facets;
	}

	public Colour getColour(int index) {
		return facets.get(index);
	}

	public int relativeTwist(Cubicle cubicle) {
		return (equals(cubicle) && !facets.isEmpty()) ? cubicle.getColours().indexOf(facets.get(0)) : -1;
	}

	@Override
	public int hashCode() {
		int result = 0;
		for (Object obj : facets) {
			result += obj.hashCode();
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Cubicle)) {
			return false;
		}
		Cubicle other = (Cubicle) obj;
		if (facets == null) {
			if (other.facets != null) {
				return false;
			}
		} else if (!(facets.containsAll(other.facets) && other.facets.containsAll(facets))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		String result = "[ ";
		for (Colour colour : facets) {
			result += colour + " ";
		}
		return result + "]";
	}

}
