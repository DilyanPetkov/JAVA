package bg.uni.sofia.fmi.mjt.cinema.reservation.system.core;

import java.util.List;

public class Movie{
	private String name;
	private int duration;
	private MovieGenre genre;

	public Movie(String name, int duration, MovieGenre genre) {
		this.name = name;
		this.duration = duration;
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public MovieGenre getGenre() {
		return genre;
	}

	public void setGenre(MovieGenre genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (genre != other.genre)
			return false;
		return true;
	}
}
