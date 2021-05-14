import java.util.*;

/**
    The Stacks class must keep track of the status of all three pegs. 
    
    @author Jeremy Hill
    @version 12.0.2
 */

public class Stacks
{
	private final int PEGNUM = 3;           //Holds the number of pegs
	private Peg[] pegs = new Peg[PEGNUM];   //Creates an array of Peg objects  
	private int startRing = 0;              //Holds the number of rings 
	private int tempRing = 0;               //Holds start peg's top diam
	
	
	/**
     *	The Stacks method is a constructor method that creates three new Peg
     *	objects in the Peg array. The first peg is initialized with the rings. 
     *	
     *	Precondition:  1 <= numRings <= 64
     *	Postcondition: The stacks have been initialized with numRings on the
     *				   first peg and no rings on the other two pegs. The 
     *				   diameters of the first peg's rings are from one inch 
     *				   (on the top) to numRings inches (on the bottom).
     *	@param numRings The number of rings the user wants to play with.
	 */
	public Stacks(int numRings)
	{
		pegs[0] = new Peg(numRings);
		pegs[1] = new Peg(0);
		pegs[2] = new Peg(0);
		
		startRing = numRings;         //Holds the number of rings in the game
	}
	
	
    /**
     *	The countRings method calls the peg class's getRings method for a 
     *	specific peg. This method then returns the number of rings on the 
     *	specified Peg.
     *
     *	Precondition:  pegNumber is 1, 2, or 3
     *	Postcondition: The return value is the number of rings on the 
     *				   specified peg.
     *	@param pegNumber The peg that the rings will be counted from.
     *	@return The number of rings on the specified peg.
	 */
	public int countRings(int pegNumber)
	{
		return pegs[pegNumber-1].getRings();
	}
	
	
	/**
     *	The getTopDiameter method calls the peg class's getDiam method for a 
     *	specific peg. This method then returns the diameter of the top ring 
     *	on the specified Peg.
     *	
     *	Precondition:  pegNumber is 1, 2, or 3
     *	Postcondition: If countRings(pegNumber) > 0, then the return value is 
     *				   the diameter of the top ring on the specified peg; 
     *				   otherwise, the return value is zero.	
     *	@param pegNumber The peg that the top diameter will be found.
     *	@return The diameter of the top ring on the specified peg.
	 */
	public int getTopDiameter(int pegNumber)
	{
		return pegs[pegNumber-1].getDiam();
	}
	
	
	/**
     *	The move method utilizes Peg's removeRing and addRing methods to move
     *	the rings. First it sets an instance variable equal to the diameter of
     *	the starting ring. It then calls the removeRing method and addRing 
     *	methods from Peg. 
     *
     *	Precondition:  stargPeg is a pegnumber (1, 2, or 3), and 
     *				   countRings(startPeg) > 0; endPeg is a different peg 
     *				   number (not equal to startPeg), and if endPeg has at 
     *				   least one ring, then getTopDiameter(startPeg) is less 
     *				   than getTopDiameter(endPeg).
	 *	Postcondition: The top ring has been moved from startPeg to endPeg.	
     *	@param startPeg The number of the starting peg.
     *	@param endPeg The number of the ending peg.
	 */
	public void move(int startPeg, int endPeg)
	{
		tempRing = getTopDiameter(startPeg); //Holds start peg's top diam
		pegs[startPeg-1].removeRing();       //Calls removeRing method
		pegs[endPeg-1].addRing(tempRing);    //Calls addRing method
	}
	
	
	/**
     *	The displayStacks method prints Peg 1 Peg 2 and Peg 3 to the screen.
     *	Underneath the contents of each Peg is printed. This allows the user
     *	to track the moves they are making throughout the game.
     *	
     * 	Precondition:  the game has started
	 *	Postcondition: a display indicating each peg and the stack of rings on
	 *				   each peg has been displayed with the smallest ring shown
	 *				   on top.
	 */
	public void displayStacks()
	{
		//Formatted peg display
		System.out.println("Peg 1       Peg 2       Peg 3");

		//Nested loop to print the contents of each peg in the array
		for (int i = 0; i < startRing; i++)
		{
			for (int j = 0; j < PEGNUM; j++)
			{
				if(i < pegs[j].getArrayList().size())
				{
					System.out.print(pegs[j].getArrayList().get(i) +  
									 "           ");
				}
				else
				{
					//Printed if peg is empty
					System.out.print("            ");
				}
			}
			System.out.println();
		}
	}
}