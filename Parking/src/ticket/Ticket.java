package ticket;

import java.util.Random;

public class  Ticket {
	public long HowManySeconds() {
		Random rn = new Random();
		int answer = rn.nextInt(10) + 1;
		return answer;
	}
}
