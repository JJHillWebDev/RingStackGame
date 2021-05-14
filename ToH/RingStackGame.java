import java.util.*;

/**
	There are 3 pegs. On the first peg are some number of rings. Each ring is
	a unique diameter. At the start of the game, all the rings are on the first
	peg and they are stacked in order of the largest diameter on the bottom to 
	the smallest diameter on the top.
	
	The object of the game is to get all of the rings on to peg number 2 
	stacked in the same order, that is from the largest diameter ring on the
	bottom to the smallest diameter ring on the top.

    @author Jeremy Hill
    @version 12.0.2
 */

public class RingStackGame
{
	//will contain the game loop
	//will ask the user if they want to play the game
	//will ask the user how many rings does he/she wish to play with
	//will contain a loop that will loop as long as the user wishes
	public static void main (String[] args)
	{
		int rings;             //Holds the number of rings the user selects
		int start = 0;         //Holds the starting peg the user chooses
		int end = 0;           //Holds the ending peg the user chooses
		String input = "";     //Holds the user's choice to play the game
		String cont = "";      //Holds the user's choice to continue the game
		String confirm = "";   //Holds the user's conformation
 		
 		//Creates a scanner object
		Scanner keyboard = new Scanner(System.in); 
		//Ask user to play the game
        System.out.print("Would you like to play the Ring Stack Game?  " +
        				 "Y / N:  ");
        //Holds the user's answer
        input = keyboard.nextLine();
        
        //If the user's answer is y or Y the game will start
        if (input.trim().equalsIgnoreCase("y"))
        {
        	//Ask the user how many rings they wish to play with
        	System.out.print("How many rings would you like to play with? " +
        					 "64 (max):  ");
        	//Holds their answer
        	rings = keyboard.nextInt();
        	
        	//Precondition for rings being 1 through 64
        	if (1 <= rings && rings <= 64)
        	{
        		//Creates a new Stacks object
        		Stacks ringGame = new Stacks(rings);    
        		//Calls the displayStacks method
        		ringGame.displayStacks();               
				
				//The game will continue until the break is met
        		while(true)
        		{
        			//Ask user to move a ring
        			System.out.print("Would you like to move a ring?" +
        							   " Y / N: ");
        			keyboard.nextLine();         //Consumes rest of line
        			cont = keyboard.nextLine();  //Holds their answer

        			if (cont.equalsIgnoreCase("y"))
        			{
	        			//Asks user which Peg they want to take a ring from
	        			System.out.print("Which peg would you like to " +
	        						     "take a ring from?:   ");
	        			//Holds their answer
	        			start = keyboard.nextInt();
	        			//Asks which peg they want to move the ring to
	        			System.out.print("Which peg would you like to " +
	        							 "move the ring to?:   ");
	        			//Holds their answer
	        			end = keyboard.nextInt();
	        			System.out.print("");

						//Validates moves before calling move method
	       				if(validMove(ringGame, start, end))
	       				{
	       					//Calls the move method
	       					ringGame.move(start,end);  
	       					//Calls the displayStacks method
	       					ringGame.displayStacks();  
							
							//If pegs 1 & 3 are both at 0 the user wins
	       					if (ringGame.countRings(1) == 0 && 
	       						ringGame.countRings(3) == 0)
	       					{
	       						//User win breaks the loop
	       						System.out.println("Congratulations!!! " +
	       										   "You Won!!!");
	       						System.out.println("");
	       						break;
	       					}
	       				}
	       				else
	       				{
	       					//Prompts user of invalid move
	       					System.out.println("Invalid move. Try again.");
	       				}
		       			
	       			}
	       			else
	       			{
	       				System.out.println("Better luck next time.");
	       				break;
	       			}
       			}
        	}
        	else
        	{
        		//Prompts user of invalid ring amount
        		System.out.println("Invalid ring amount. Try again.");
        	}
        }
        else
        {
        	//Prompt for user that doesn't want to play
        	System.out.println("Maybe another time.");
        }
	}
	
	/**
     *	The validMove method is used to validate that the game rules have not
     *	been violated in each move.
     *	
     *	Precondition:  game is a reference to the Stacks object; startPeg 
     *				   contains the peg number that the ring is being moved
     * 				   from; endPeg contains the peg number that the ring is 
     *				   being moved to.
	 *	Postcondition: It has been determined whether or not the appropriate
	 *				   game rules have been violated. If any of them have, an
	 *				   appropriate error message is displayed and false has 
	 *				   been returned. If no rules have been violated, true has
	 *				   been returned.
     *	@param game The current Ring Stack Game.
     *	@param startPeg The starting peg for a move.
     *	@param endPeg The ending peg for a move.
     *	@return Boolean if the move is valid to make.
	 */
	public static boolean validMove(Stacks game, int startPeg, int endPeg)
	{
		boolean valid = false;          //Hold boolean to be returned

		//Precondition that start peg is 1 through 3
		if (1<= startPeg && startPeg <=3)
		{
			//Precondition that end peg is 1 through 3
			if (1<= endPeg && endPeg <=3)
			{
				//Precondition that start peg has a ring
				if (game.countRings(startPeg) > 0)
				{
					//Precondition that the start and end pegs aren't equal
					if (endPeg != startPeg)
					{
						//If end peg has rings then check the top diameters
						if(game.countRings(endPeg) > 0)
		 				{
		 					//Precondition that checks top diam of both pegs
		 					if (game.getTopDiameter(startPeg) < 
		 						game.getTopDiameter(endPeg))
		 					{
		 						//Boolean is true
		 						valid = true;
		 					}
		 				}
		 				else
		 				{
		 					//Boolean is true
		 					valid = true;
		 				}
		 			}
		 		}
		 	}
		}
		//Returns boolean results
		return valid;
	}
}
        