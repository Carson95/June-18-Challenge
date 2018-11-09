import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DiceRoller {
	
	private static ArrayList<String> enteries = new ArrayList<>();

	//in the main we will gather all the enteries to roll
	public static void main(String[] args) {
		String entry;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Enter your dice in the numDsides format such as 3d6 - enter stop to end entries");
			entry = scan.next();
			if (!entry.equalsIgnoreCase("stop")) {
				enteries.add(entry);
			}
		} while(!entry.equalsIgnoreCase("stop"));
		//System.out.println("Number of enteries = " + enteries.size());
		rollDice();
	}
	
	//here we will roll the dice and get an output
	private static void rollDice() {
		Random r = new Random();
		for (int i = 0; i < enteries.size(); i++) {
			int numOfDice; //how many dice we will roll
			int numOfSides; //how many sides each dice has
			String num = enteries.get(i).replace('d', ' ');
			String[] numbers = num.split(" ");
			numOfDice = Integer.parseInt(numbers[0]);
			numOfSides = Integer.parseInt(numbers[1]);
			//System.out.println(numOfDice);
			//System.out.println(numOfSides);
			int max = numOfDice * numOfSides;
			int rolled = 0; //what we have rolled
			for (int j = 0; j < numOfDice; j++) {
				rolled += r.nextInt(numOfSides) + 1;
			} //end of nested for loop
			System.out.println("Number rolled is between " + numOfDice + " and " + max + ". Number was: " + rolled);
		} //end of first for loop
	}

}
