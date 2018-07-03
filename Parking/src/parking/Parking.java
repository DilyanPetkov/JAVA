package parking;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import car.*;
public class Parking {
	private List<Car> cars;
	private int sizeOfParking;
	private static int numOfCars = 0;
	private long arrivalTime;
	public Parking(int sizeOfParking) {
		this.sizeOfParking = sizeOfParking;
		this.cars = new ArrayList<>(sizeOfParking);
	}
	public void print() {
		for(int i = 0;i<this.cars.size();i++) {
			System.out.println(cars.get(i).getBrand());
		}
	}
	public long parkCar(Car car) throws InterruptedException {
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				if(numOfCars < sizeOfParking) {
					cars.add(car);
					long time = System.nanoTime();
					time = arrivalTime;
					numOfCars++;
				}
				
				
			}
			
		});
		t1.start();	
		return this.arrivalTime;
		/*synchronized(this){
			while(sizeOfParking == numOfCars) {
				System.out.println("no spaces");
				wait();
			}
			System.out.println("A " + car.getBrand() +" has just been parked.");
			cars.add(car);
			Parking.numOfCars++;
			this.arrivalTime = System.nanoTime();
			notify();
			Thread.sleep(1000);
			}
		return this.arrivalTime;*/
	}
	public void checkParking(){
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		exec.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				long currentTime;			
				for(int i = 0;i<cars.size();i++) {
					if(cars.get(i) != null) {
						long time = 0;
						try {
							time = parkCar(cars.get(i));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						currentTime = System.nanoTime();
						if((currentTime - time)/1000000000 > cars.get(i).getTicket().HowManySeconds()) {
							System.out.println(cars.get(i).getBrand() + " has just been removed");
							cars.remove(i);
							
						}
					}
				}
			}
		},0 , 5000, TimeUnit.SECONDS);

	}
}
