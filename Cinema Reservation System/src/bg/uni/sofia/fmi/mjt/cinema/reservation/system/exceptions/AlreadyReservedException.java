package bg.uni.sofia.fmi.mjt.cinema.reservation.system.exceptions;

public class AlreadyReservedException extends Exception {

	private static final long serialVersionUID = -5084252001201440453L;
	public AlreadyReservedException() {
		super();
	}
	public AlreadyReservedException(String a) {
		super(a);
	}
}
