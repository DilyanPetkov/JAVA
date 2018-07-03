import car.Car;
import parking.Parking;
import ticket.Ticket;
public class Main {
	public static void main(String[] argc) throws InterruptedException {

	Ticket t1 = new Ticket();
	Ticket t2 = new Ticket();
	Ticket t3 = new Ticket();
	Ticket t4 = new Ticket();
	
	Car c1 = new Car("Opel",t1);
	System.out.println(c1.getTicket().HowManySeconds());
	
	Car c2 = new Car("Toyota",t2);
	System.out.println(c2.getTicket().HowManySeconds());
	
	Car c3 = new Car("Golf2",t3);
	System.out.println(c3.getTicket().HowManySeconds());
	
	Car c4 = new Car("Seat",t4);
	System.out.println(c4.getTicket().HowManySeconds());
	
	
	
	Parking parking = new Parking(4);
	parking.print();
	
	
	parking.parkCar(c1);
	parking.parkCar(c2);
	parking.parkCar(c3);
	parking.parkCar(c4);
	parking.checkParking();
	parking.print();

	}
	
}
