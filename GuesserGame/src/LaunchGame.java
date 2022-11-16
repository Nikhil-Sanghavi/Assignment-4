import java.util.*;

class Guesser
{
	private int guessNum ;
	
	public int getGuessNum() {
		return guessNum;
	}
	public void setGuessNum(int guessNum) {
		this.guessNum = guessNum;
	}

	int guessNum(int maxNum)
	{
		setGuessNum(Umpire.guessNum(maxNum, "Guesser"));
		return getGuessNum();
	}	
}

class Player
{
	private String name;
	private boolean winner; // true means winner
	private boolean inActive;// true means player is out and not allowed to play
	private int guessNum;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGuessNum() {
		return guessNum;
	}
	public void setGuessNum(int guessNum) {
		this.guessNum = guessNum;
	}
	
	public boolean isWinner() {
		return winner;
	}
	public void setWinner(boolean winner) {
		this.winner = winner;
	}
	public boolean isInActive() {
		return inActive;
	}
	public void setInActive(boolean inActive) {
		this.inActive = inActive;
	}
	
	public Player() {
		System.out.println("Enter your name :");
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		this.name = name;
//		scan.close();
	}
	void guessNum(int maxNum)
	{
		setGuessNum(Umpire.guessNum(maxNum, this.name));
	}
}

class Umpire
{
	private int totPlayers;
	private int maxNum;
	private int numFromGuesser;
	
	List<Player> players = new ArrayList<>();
	
	public Umpire(int totPlayers, int maxNum) {
		this.totPlayers = totPlayers;
		this.maxNum = maxNum;
		createPlayers();
		collectNumFromGuesser();
	}


	public static int guessNum(int maxNum, String name)
	{
		int num;
		Scanner scan=new Scanner(System.in);
		do {
			System.out.println(name + " kindly guess the number range is > 0 and < " + maxNum);
			num = scan.nextInt();
		}while(num <= 0 || num > maxNum);
		return num;
	}	

	private void createPlayers() {
		System.out.println("Creating total " + totPlayers + " players...");
		for (int i = 0; i<totPlayers; i++)
			players.add(new Player());
	}
	
	private void collectNumFromGuesser()
	{
		Guesser g=new Guesser();
		numFromGuesser=g.guessNum(maxNum);
	}

	boolean play()
	{
		boolean success = false;
		for (Player player : players)
			if (!player.isInActive()) // bypass inactive players
			{
				player.guessNum(maxNum); //collect fresh number
				if (player.getGuessNum() == numFromGuesser)
				{
					player.setWinner(true);
					success = true;
				}
			}
		if (success) //check if more than one player then it is a tie. so, make other play
		{
			int totWinners = 0;
			for (Player player : players)
			{
				if (player.isWinner())
					totWinners++;
			}
			// totwinners 
			//0 => repeat the game 
			//1 ==> game over result declared
			//others ==> make loosers as inActive, winners as false and repeat the game for remaining winners
			System.out.println("total " + totWinners + " players won!!!");
			switch (totWinners) 
			{
				case 0: 
					System.out.println("no winners so repeating game");
					break;
				case 1:
					return success;
				default: // make loosers as inactive
					System.out.println("more than one player has won");
					for (Player player : players)
						if (player.isWinner()) {
							player.setWinner(false); //if winner, make it false for next game
							System.out.println(player.getName() + " won so will play again");
						}
						else {
							player.setInActive(true); // if looser, make it inactive
							System.out.println(player.getName() + " lost so will quit");
						}
					break;
			}
		}
		return false;
	}
	
	String result() {
		for (Player player : players) {
			if (player.isWinner())
				return player.getName();
			break;
		}
		return null;
	}
}

public class LaunchGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int totPlayers;
		int maxNum;
		do
		{
			System.out.println("Enter total number of players (minimum 2 required) :");
			totPlayers = scan.nextInt();
		}while(totPlayers <= 1);
		do {
			System.out.println("Enter maximum number to be guessed (should be > 0)");
			maxNum = scan.nextInt();
		}while(maxNum <= 0);
		
		Umpire u=new Umpire(totPlayers, maxNum);
		while(!u.play()) {
				System.out.println("Repeating game ..");
				
		}
		System.out.println("The winner is : " + u.result());
		scan.close();
	}
}
