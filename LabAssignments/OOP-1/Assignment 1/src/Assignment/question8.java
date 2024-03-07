package Assignment;

public class question8 {

	public static void main(String[] args) {
		int initialRabbits = 1042;
		int initialBirds = 2272;
        double rabbitRate = 0.038;
        double birdRate = 0.012;
        int years = 0;
		
        while(initialRabbits <= initialBirds) {
            initialRabbits += (int) (initialRabbits * rabbitRate);
            initialBirds += (int) (initialBirds * birdRate);
            years++;
        }
        
        System.out.println("In " + years +" years, there will be more rabbits than birds");
	}

}
