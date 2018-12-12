import java.util.Scanner;

public static class Player
	{
		int score;	
		char marker;
		boolean turn;
		
		Player(char marker, boolean turn)
		{
			score=0;	
			this.marker=marker;
			this.turn=turn;
		}		
		
		boolean makeMove(int movePos, Board boardObj)
		{
			Scanner sc = new Scanner(System.in);
			if(boardObj.isValidMove(movePos))
			{
				boardObj.updateBoard(movePos, marker);
				boardObj.showBoard();
				turn=!turn;	
			}
			else
			{
				System.out.println("Not a valid selection! ");
				System.out.print("Player " + this.marker + ", please make a move: ");
				int input = sc.nextInt();
				makeMove(input-1, boardObj);
			}
			return boardObj.isWinner(this.marker);
		}
	}
