import java.util.Scanner;
public class Player {

 
		
		private String name;
		private int fastestWin;
		private int gamesCompleted;
		
		
		private Scanner keyboard = new Scanner(System.in);
		
		
		
		public String askForGuess(){
		
			
			String playerGuess = keyboard.nextLine();
			return playerGuess;	
			
		}
	

		public String getName(){
			
			return this.name;
		}

		public int getFastestWin(){
			return this.fastestWin;
		}
		
		public int getGamesCompleted(){
			return this.gamesCompleted;
	
		}
		
		public void setName(String name){
			
			this.name = name;
		}
		
		public void updateStats(int numberOfMovesTakenToWin){
			gamesCompleted ++;
			if(this.gamesCompleted == 1)
			{
				this.fastestWin = numberOfMovesTakenToWin;
			}
			
			else if (numberOfMovesTakenToWin < fastestWin)
			{
				this.fastestWin = numberOfMovesTakenToWin;
			}
		}
}
 
 


