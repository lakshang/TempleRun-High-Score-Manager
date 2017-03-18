import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TempleRunA {
	static Scanner sc = new Scanner(System.in);
	// static int reply;
	static int[] competitorNo = new int[20];
	static String[] name = new String[20];
	static int[] age = new int[20];
	static int[] noOfCoinCollected = new int[20];
	static int[] scoreAchieved = new int[20];
	static int[] distanceReached = new int[20];

	static int h_CompetitorNo = 0;
	static String h_Name = "";
	static int h_Age = 0;
	static int h_ScoreAchieved = 0;

	static int m_CompetitorNo = 0;
	static String m_Name = "";
	static int m_Age = 0;
	static int m_distanceReached = 0;

	static int d_CompetitorNo = 0;
	static String d_Name = "";
	static int d_Age = 0;
	static int d_NoOfCoinCollected = 0;

	public static void main(String[] args) {

			menu();

	}

	private static void getInputs() {
	try {
		/*
		 * System.out.println("------Temple Run Highscore Manager------");
		 * System.out.println("\t" + "Records Adding screen		 ");
		 * System.out.println("----------------------------------------");
		 */

		// System.out.println("How many Players Played today's game?");
		// reply=sc.nextInt();

		for (int i = 1; i <= 3; i++) {
			System.out.print("\n");
			System.out.print("Enter Competitor No: ");
			competitorNo[i] = sc.nextInt();

			System.out.print("Enter Name: ");
			name[i] = sc.next();

			System.out.print("Enter Age: ");
			age[i] = sc.nextInt();

			System.out.print("Enter No Of Coin Collected: ");
			noOfCoinCollected[i] = sc.nextInt();

			System.out.print("Enter Score Achieved: ");
			scoreAchieved[i] = sc.nextInt();

			System.out.print("Enter Distance Reached: ");
			distanceReached[i] = sc.nextInt();

			System.out.println();

			// CALCULATING BEST COMPETITOR BASED ON SCORE ACHIEVED
			if (scoreAchieved[i] > h_ScoreAchieved) {
				h_CompetitorNo = competitorNo[i];
				h_Name = name[i];
				h_Age = age[i];
				h_ScoreAchieved = scoreAchieved[i];
			} else if (competitorNo[i] == h_CompetitorNo) {
				h_CompetitorNo = competitorNo[i];
				h_Name = name[i];
				h_Age = age[i];
				h_ScoreAchieved = scoreAchieved[i];
			}

			// CALCULATING BEST COMPETITOR BASED ON DISTANCE REACHED
			if (distanceReached[i] > m_distanceReached) {
				m_CompetitorNo = competitorNo[i];
				m_Name = name[i];
				m_Age = age[i];
				m_distanceReached = distanceReached[i];
			} else if (distanceReached[i] == m_distanceReached) {
				m_CompetitorNo = competitorNo[i];
				m_Name = name[i];
				m_Age = age[i];
				m_distanceReached = distanceReached[i];
			}

			// CALCULATING BEST COMPETITOR BASED ON COINS COLLECTED
			if (noOfCoinCollected[i] > d_NoOfCoinCollected) {
				d_CompetitorNo = competitorNo[i];
				d_Name = name[i];
				d_Age = age[i];
				d_NoOfCoinCollected = noOfCoinCollected[i];
			} else if (distanceReached[i] == m_distanceReached) {
				d_CompetitorNo = competitorNo[i];
				d_Name = name[i];
				d_Age = age[i];
				d_NoOfCoinCollected = noOfCoinCollected[i];
			}

		}
		System.out.println("_____________________________________________________________");
		menu();
	}catch (InputMismatchException e){
		System.out.println("Invalid Input !");
		menu();
	}
	}
	private static void menu() {
					displayMenu();
					String reply1  = sc.next();
					switch (reply1) {
						case"0":
							getInputs();
							break;
						case "1":
							allPlayer();
							break;
						case "2":
							selectedPlayer();
							break;
						case "3":
							threeWinners();
							break;
						case "4":
							selectedWinner();
							break;
						default:
							System.out.println("Wrong Selection, Input a valid selection");
							menu();

					}

			}


	private static void allPlayer() {
		try {
			int i;

			for (i = 1; i < competitorNo.length; i++) {
				System.out.println(competitorNo[i] + "\t" + name[i] + "\t" + noOfCoinCollected[i] + "\t" + scoreAchieved[i]
						+ "\t" + distanceReached[i]);
			}
			System.out.println("\n");
			System.out.println("Do you wish to go back to the main menu?");
			System.out.println("Press Y to yes, Press N to no");
			char wish = sc.next().charAt(0);
			if (wish == 'y' || wish == 'Y') {
				menu();
			} else if (wish == 'n' || wish == 'N') {
				System.exit(0);
			}
		}catch (InputMismatchException e){
			System.out.println(" Invalid Input ! ");
			menu();
		}

	}

	private static void selectedPlayer() {
		try {
			System.out.println("PLEASE ENTER THE CONTESTANT NUMBER TO GET DETAILS OF A SELECTED PLAYER");
			int index = 0;
			int n = sc.nextInt();
			for (int i = 0; i <= 3; i++) {
				if (n == competitorNo[i]) {
					index = i;
					System.out.println("\n");
					System.out.println("CompetitorNo - " + competitorNo[index] + " " + "Name " + name[index] + " "
							+ "No of coin collected " + noOfCoinCollected[index] + " " + "Score Achieved "
							+ scoreAchieved[index] + " " + "Distance reached " + distanceReached[index]);
				}
			}

			if (n != competitorNo[index]) {
				System.out.println("wrong input, give a Correct contestant number");
				selectedPlayer();
			}
			System.out.println("\n");
			System.out.println("Do you wish to go back to the main menu?");
			System.out.println("Press Y to yes, Press N to no");
			char wish = sc.next().charAt(0);
			if (wish == 'y' || wish == 'Y') {
				menu();
			} else if (wish == 'n' || wish == 'N') {
				System.exit(0);
			}
		}catch (InputMismatchException e){
			System.out.println(" Invalid Input !");
			menu();
		}
	}

	private static void threeWinners() {
		try {
			System.out.println(
					h_CompetitorNo + " " + h_Name + " has got Achieved the Highest Score, which is " + h_ScoreAchieved);
			System.out.println("\n");
			System.out.println(
					m_CompetitorNo + " " + m_Name + " has ran the highest distance, which is " + m_distanceReached);
			System.out.println("\n");
			System.out.println(
					d_CompetitorNo + " " + d_Name + " has got the maximum gold coins, which is " + d_NoOfCoinCollected);
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("Do you wish to go back to the main menu?");
			System.out.println("Press Y to yes, Press N to no");

			char wish = sc.next().charAt(0);

			if (wish == 'y' || wish == 'Y') {
				menu();
			} else if (wish == 'n' || wish == 'N') {
				System.exit(0);

			}
		}catch (InputMismatchException e){
			System.out.println(" Invalid Input !");
			menu();
		}
	}

	private static void selectedWinner() {
		try {
			System.out.println("Press 1 to view the winner from Highest scores");
			System.out.println("Press 2 to view the winner from the distance reached");
			System.out.println("Press 3 to view the winner from the number of coins collected");

			int reply1 = sc.nextInt();
			switch (reply1) {

				case 1:
					System.out.println("Competitor number : " + h_CompetitorNo);
					System.out.println("Name              : " + h_Name);
					System.out.println("Score             : " + h_ScoreAchieved);
					break;
				case 2:
					System.out.println("Competitor number : " + m_CompetitorNo);
					System.out.println("Name              : " + m_Name);
					System.out.println("Score             : " + m_distanceReached);
					break;
				case 3:
					System.out.println("Competitor number : " + d_CompetitorNo);
					System.out.println("Name              : " + d_Name);
					System.out.println("Score             : " + d_NoOfCoinCollected);
					break;
			}
		}catch (InputMismatchException e){
			System.out.println(" Invalid Input !");
			menu();
		}
	}
	public static void displayMenu(){
		System.out.println("*************************************************************");
		System.out.println("*\t" + "WELCOME TO TEMPLE RUN HIGHSCORE MANAGER             *");
		System.out.println("*                                                           *");
		System.out.println("*************************************************************");
		System.out.println("* press 0 to Enter Ur records                               *");
		System.out.println("*                                                           *");
		System.out.println("*************************************************************");
		System.out.println("*************************************************************");
		System.out.println("*                                                           *");
		System.out.println("* press 1 to view all player details                        *");
		System.out.println("* Press 2 to view selected player using contestent number   *");
		System.out.println("* Press 3 to view top 3 players                             *");
		System.out.println("* Press 4 to view a selected winner                         *");
		System.out.println("*                                                           *");
		System.out.println("*************************************************************");
	}
}
