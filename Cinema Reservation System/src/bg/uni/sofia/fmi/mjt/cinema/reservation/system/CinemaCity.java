package bg.uni.sofia.fmi.mjt.cinema.reservation.system;

import java.time.LocalDateTime;
import java.util.*;

import bg.uni.sofia.fmi.mjt.cinema.reservation.system.core.*;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.exceptions.*;

public class CinemaCity implements CinemaReservationSystem {
	public CinemaCity(Map<Movie, List<Projection>> cinemaProgram) {
		this.cinemaProgram = cinemaProgram;
		this.reservedTickets = new ArrayList<Ticket>();
	}

	public CinemaCity() {
		this.reservedTickets = null;
		this.cinemaProgram = null;
	}

	@Override
	public void bookTicket(Ticket ticket) throws AlreadyReservedException, ProjectionNotFoundException,
			InvalidSeatException, ExpiredProjectionException {
		boolean flag = false;
		List<Projection> pr = new ArrayList<Projection>();
		pr = this.cinemaProgram.get(ticket.getProjection().getMovie());
		if (!pr.contains(ticket.getProjection())) {
			flag = true;
			throw new ProjectionNotFoundException("Projection not found.");
		}
		if (reservedTickets.contains(ticket)) {
			flag = true;
			throw new AlreadyReservedException("Already reserved");
		}
		if (ticket.getProjection().getDate().isBefore(LocalDateTime.now())) {
			flag = true;
			throw new ExpiredProjectionException("Expired projection");
		}
		if (ticket.getProjection().getHall().getRows() <= ticket.getSeat().getRow()
				|| ticket.getProjection().getHall().getRowSeats() <= ticket.getSeat().getRow()) {
			flag = true;
			throw new InvalidSeatException("Invalid seat.");
		}
		if (!flag) {
			reservedTickets.add(ticket);
		}

	}

	@Override
	public void cancelTicket(Ticket ticket) throws ReservationNotFoundException, ProjectionNotFoundException {
		List<Projection> pr = new ArrayList<Projection>();
		pr = this.cinemaProgram.get(ticket.getProjection().getMovie());
		boolean flag = false;
		if (!pr.contains(ticket.getProjection())) {
			flag = true;
			throw new ProjectionNotFoundException("Projection not found.");
		}
		if (!this.reservedTickets.contains(ticket)) {
			flag = true;
			throw new ReservationNotFoundException("Reservation not found");
		}
		if(!flag) {
			reservedTickets.remove(ticket);
		}
		
	}

	@Override
	public int getFreeSeats(Projection projection) throws ProjectionNotFoundException {
		int freeSeats = 0;
		int all = projection.getHall().getRows() * projection.getHall().getRowSeats();
		List<Projection> p = new ArrayList<Projection>();
		p = cinemaProgram.get(projection.getMovie());
		if (!p.contains(projection)) {
			throw new ProjectionNotFoundException("No such projection");
		}
		for (Ticket tkt : reservedTickets) {
			if (tkt.getProjection().equals(projection))
				freeSeats++;
		}
		return all - freeSeats;
	}

	@Override
	public Collection<Movie> getSortedMoviesByGenre() {
		List<Movie> allMoviesSorted = new ArrayList<Movie>(this.cinemaProgram.keySet());
		Collections.sort(allMoviesSorted, new Comparator<Movie>() {
			@Override
			public int compare(Movie a, Movie b) {
				return a.getGenre().compareTo(b.getGenre());
			}
		});
		return allMoviesSorted;
	}

	Map<Movie, List<Projection>> cinemaProgram;
	List<Ticket> reservedTickets;
}
