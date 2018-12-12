	public static class Board
	{
		
		//123
		//456
		//789
		int size;
		char[] positionNumbers;
		boolean gameOver;
		
		Board(int size)
		{
			positionNumbers = new char[size*size];
			for(int i=0; i< positionNumbers.length; i++)
			{
				positionNumbers[i]='-';
			}
			this.size=size;
			gameOver=false;
		}
		
		void updateBoard(int boardPos, char playerMarker)
		{
			positionNumbers[boardPos] = playerMarker;
		}
		
		void showBoard()
		{
			System.out.println("\n");
			for(int i=0; i< positionNumbers.length; i++)
			{
				if(i%size == size-1)
				{
					System.out.println(positionNumbers[i]);
				}
				else
				{
					System.out.print(positionNumbers[i]);
				}	
			}	
		
		}	

		
		
	
		boolean isValidMove(int position)
		{
			if( position<positionNumbers.length && position>=0 && positionNumbers[position]=='-')
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		boolean isWinner(char playerMarker)
		{
			//System.out.println(positionNumbers.length/size);
			
			//Check each row:
			int count=0;
			while(count<positionNumbers.length/size)
			{
				int rowCount=0;
				for(int i=count*size; i<positionNumbers.length/size+count*size; i++)
				{
					if(positionNumbers[i]==playerMarker)
					{
						rowCount++;
					}					
				}
				count++;
				//System.out.println("Row count: " + playerMarker + " = " + rowCount);
				if(rowCount==size)
				{
					System.out.println("Player " + playerMarker + " wins!!");
					this.gameOver=true;
					return true;
				}
			}

			//Check each column:
			int count1=0;
			while(count1<positionNumbers.length/size)
			{
				int columnCount=0;
				for(int i=count1; i<=positionNumbers.length-(size-count1); i+=size)
				{
					//System.out.println(i);
					if(positionNumbers[i]==playerMarker)
					{
						columnCount++;
					}					
				}
				count1++;
				//System.out.println("Column count: " + playerMarker + " = " + columnCount);
				if(columnCount==size)
				{
					System.out.println("Player " + playerMarker + " wins!!");
					this.gameOver=true;
					return true;
				}
			}	
			
			boolean diagR=true;
			boolean diagL=true;
			//Check Right Diagonal
			for(int i=0; i< positionNumbers.length; i+=size+1)
			{
				if(positionNumbers[i]!=playerMarker)
				{
					diagR=false;			
				}	
			}
			
			//Check Left Diagonal
			for(int i=size-1; i<=positionNumbers.length-size; i+=size-1)
			{
				if(positionNumbers[i]!=playerMarker)
				{
					diagL=false;			
				}	
			}
						
			if(diagR || diagL)
			{
				System.out.println("Player " + playerMarker + " wins!!");
					this.gameOver=true;
					return true;
				
			}
				
			return false;	
		}
	
		
	}
