package car;

import ticket.Ticket;

public class Car {
	private String brand;
	private Ticket ticket;
	public Car(String brand, Ticket ticket) {
		this.brand = brand;
		this.ticket = ticket;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
}
