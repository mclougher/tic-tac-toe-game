public class ticTacToe
{
	
	public static void main(String[] args)
	{
		int sizeOfBoard=3;
		//Player X will go first
		Player xPlayer = new Player('X', true);
		Player oPlayer = new Player('O', false);
		
		Player[] allPlayers = new Player[2];
		allPlayers[0]=xPlayer;
		allPlayers[1]=oPlayer;
		//Tic-Tac-Toe is 3x3 square
		Board board = new Board(sizeOfBoard);
		board.showBoard();	
		
		Scanner sc = new Scanner(System.in);
		
		
		int turnNumber=0;
		while(board.gameOver==false && turnNumber<sizeOfBoard*sizeOfBoard)
		{
			if(allPlayers[turnNumber%2].turn==true)
			{
				System.out.print("Player " + allPlayers[turnNumber%2].marker + ", please make a move: ");
				int input = sc.nextInt();
				//"-1" to avoid confusion of zero index
				allPlayers[turnNumber%2].makeMove(input-1,board);
				allPlayers[(turnNumber%2+1)%2].turn=true;
			}	
			turnNumber++;	

		}
		
		if(board.gameOver==false && turnNumber==sizeOfBoard*sizeOfBoard)
		{
			System.out.println("It's a draw!");
		}
	

	}
	
}
